#pragma once

#include"prefix.h"
// hehe
class Mtl
{
public:
	Mtl(char* n);
	float K[3][3];
	float Ns;
	char* name;
	Mtl& operator =(Mtl& a);
	~Mtl(void);
};
