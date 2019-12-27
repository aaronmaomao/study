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
	Client(int socket, const Server& server);
	virtual ~Client();
	int getSocket() const {
		return socket;
	}
private:
	int socket;
	const Server& server;

	static void* do_client_task(void*);
};

#endif /* CLIENT_H_ */
