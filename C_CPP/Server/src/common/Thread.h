/*
 * Thread.h
 *
 *  Created on: 2019年12月27日
 *      Author: maozj
 */

#ifndef THREAD_H_
#define THREAD_H_

#include <pthread.h>

class Runnable;

class Thread {
public:
	Thread(Runnable &runnable);
	virtual ~Thread();
	void start();

private:
	Runnable &runnable;
	pthread_t pthread { 0 };
};

#endif /* THREAD_H_ */
