/*
 * Client.cpp
 *
 *  Created on: 2019年12月26日
 *      Author: maozj
 */

#include "Client.h"

#include <pthread.h>
#include <stddef.h>
#include <sys/socket.h>
#include <cstdio>
#include <iostream>

#include "Server.h"

using namespace std;

Client::Client(int socket, Server &server) :
		socket(socket), server(server) {
	pthread_t pthread;
	pthread_create(&pthread, NULL, do_client_task, (void*) this);
}

Client::~Client() {
}

void* Client::do_client_task(void *_client) {
	Client *client = (Client*) _client;
	size_t buffer_size = 1024;
	char buffer[buffer_size];
	int len = 0;
	do {
		len = recv(client->getSocket(), (void*) buffer, buffer_size, 0);
		printf("%d : %s", client->getSocket(), buffer);
		client->getServer().sendToClient(client, buffer, len);
	} while (len > 0);
	cout << "socket " << client->getSocket() << " closed !" << endl;
	return 0;
}

