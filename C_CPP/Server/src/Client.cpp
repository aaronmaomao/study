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
#include <iostream>

using namespace std;

Client::Client(int socket, const Server &server) :
		socket(socket), server(server) {
	cout << "asdasdasd";
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
		len = recv(client->getSocket(), (void*) buffer, buffer_size, '\n');
		cout << client->getSocket() << " : " << buffer;
	} while (len > 0);
	return 0;
}

