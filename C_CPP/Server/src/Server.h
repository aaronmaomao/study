/*
 * Server.h
 *
 *  Created on: 2019年12月26日
 *      Author: maozj
 */

#ifndef SERVER_H_
#define SERVER_H_

#include <netinet/in.h>
#include <list>
#include <string>

#include "Client.h"

using namespace std;

class Server {
public:
	Server(string name, int port);
	virtual ~Server();
	int start();

	const string& getName() const {
		return name;
	}

	int add_client(Client*);
	Client* re_client(Client*);

	int getPort() const {
		return port;
	}

	void sendToClient(Client*, char *msg, int len);

private:
	string name { "Unknow" };
	int port { 8888 };
	int server_socket { NULL };
	sockaddr_in server_socket_addr { 0 };

	list<Client*> clients;

	static void* do_accept_task(void *_server);
};

#endif /* SERVER_H_ */
