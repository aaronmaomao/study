/*
 * Server.cpp
 *
 *  Created on: 2019年12月26日
 *      Author: maozj
 */

#include "Server.h"

#include <pthread.h>
#include <sys/socket.h>
#include <iostream>

Server::Server(string name, int port) :
		name(name), port(port) {
}

Server::~Server() {
	// TODO Auto-generated destructor stub
}

int Server::start() {
	this->server_socket = socket(AF_INET, SOCK_STREAM, 0);
	this->server_socket_addr.sin_family = AF_INET;
	this->server_socket_addr.sin_addr.s_addr = INADDR_ANY;
	this->server_socket_addr.sin_port = this->port;
	listen(server_socket, 20);

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
	cout << server->getName() << " : " << "acceptor task starting..." << endl;

	while (1) {
		sockaddr_in client_addr;
		socklen_t client_addr_size;
		int client_socket = accept(server->server_socket, (sockaddr*) &client_addr, &client_addr_size);

		Client* client = new Client(client_socket);
		server->add_client(client);
	}

	return 0;
}
