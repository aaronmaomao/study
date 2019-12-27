/*
 * Server.cpp
 *
 *  Created on: 2019年12月26日
 *      Author: maozj
 */

#include "Server.h"

#include <pthread.h>
#include <string.h>
#include <sys/socket.h>
#include <iostream>

using namespace std;

Server::Server(string name, int port) :
		name(name), port(port) {
}

Server::~Server() {
	// TODO Auto-generated destructor stub
}

int Server::start() {
	this->server_socket = socket(AF_INET, SOCK_STREAM, 0);
	memset(&this->server_socket_addr, 0, sizeof(this->server_socket_addr));
	this->server_socket_addr.sin_family = AF_INET;
	this->server_socket_addr.sin_addr.s_addr = INADDR_ANY;
	this->server_socket_addr.sin_port = htons(this->port);
	bind(this->server_socket, (sockaddr*) &(this->server_socket_addr), sizeof(sockaddr));
	listen(this->server_socket, 20);
	pthread_t accept_task_thread;
	pthread_create(&accept_task_thread, NULL, Server::do_accept_task, (void*) this);
	return 0;
}

int Server::add_client(Client*) {
	return 1;
}

Client* Server::re_client(string name) {
	return NULL;
}

void* Server::do_accept_task(void *_server) {
	Server *server = (Server*) _server;
	cout << server->getName() << " : " << "acceptor task starting in " << server->getPort() << " ...." << endl;

	for (;;) {
		sockaddr_in client_addr;
		socklen_t client_addr_size;
		int client_socket = accept(server->server_socket, (sockaddr*) &client_addr, &client_addr_size);
		cout << "new socket " << client_socket << " accepted !" << endl;
		Client *client = new Client(client_socket, *server);
		server->add_client(client);
	}

	return 0;
}
