#include <iostream>
#include <string>

#include "Server.h"

/*
 * main.cpp
 *
 *  Created on: 2019年12月26日
 *      Author: maozj
 */

int main(int argc, char **argv) {
	Server server("Server", 9999);
	server.start();
	string cmd;
	cin>>cmd;
}
