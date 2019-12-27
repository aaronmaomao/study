/*
 * Thread.cpp
 *
 *  Created on: 2019年12月27日
 *      Author: maozj
 */

#include "Thread.h"

#include <pthread.h>

#include "Runnable.h"
static void* run(void*);
Thread::Thread(Runnable &runnable) :
		runnable(runnable) {
}

Thread::~Thread() {
}

void Thread::start() {
	pthread_create(&pthread, NULL, run, (void*) &runnable);
}

static void* run(void *_runnable) {
	Runnable *runnable = (Runnable*) _runnable;
	runnable->run();
	return 0;
}
