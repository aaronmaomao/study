/*
 * Client.h
 *
 *  Created on: 2019年12月26日
 *      Author: maozj
 */

#ifndef CLIENT_H_
#define CLIENT_H_

class Client {
public:
	Client(int socket);
	virtual ~Client();
	int getSocket() const {
		return socket;
	}
private:
	int socket;
};

#endif /* CLIENT_H_ */
