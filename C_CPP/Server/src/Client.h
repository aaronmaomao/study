/*
 * Client.h
 *
 *  Created on: 2019年12月26日
 *      Author: maozj
 */

#ifndef CLIENT_H_
#define CLIENT_H_

class Server;

class Client {
public:
	Client(int socket, Server &server);
	virtual ~Client();
	int getSocket() const {
		return socket;
	}

	Server& getServer() const {
		return server;
	}

private:
	int socket;
	Server &server;

	static void* do_client_task(void*);
};

#endif /* CLIENT_H_ */
