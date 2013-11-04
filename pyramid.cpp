#include "pyramid.h"
#include "prefix.h"
pyramid::pyramid(void)
{
	vertex_count=8;
	face_count=6;
	vertex_list=new VERTEX[8];
	face_list=new FACE[6];
	vertex_list[0].xyz[0]=-1;//上左前点
	vertex_list[0].xyz[1]=1;
	vertex_list[0].xyz[2]=1;

	vertex_list[1].xyz[0]=-1;//上左后点
	vertex_list[1].xyz[1]=1;
	vertex_list[1].xyz[2]=-1;

	vertex_list[2].xyz[0]=1;//上右后点
	vertex_list[2].xyz[1]=1;
	vertex_list[2].xyz[2]=-1;

	vertex_list[3].xyz[0]=1;//上右前点
	vertex_list[3].xyz[1]=1;
	vertex_list[3].xyz[2]=1;

	vertex_list[4].xyz[0]=-1;//下左前点
	vertex_list[4].xyz[1]=-1;
	vertex_list[4].xyz[2]=1;

	vertex_list[5].xyz[0]=-1;//下左后点
	vertex_list[5].xyz[1]=-1;
	vertex_list[5].xyz[2]=-1;

	vertex_list[6].xyz[0]=1;//下右后点
	vertex_list[6].xyz[1]=-1;
	vertex_list[6].xyz[2]=-1;

	vertex_list[7].xyz[0]=1;//下右前点
	vertex_list[7].xyz[1]=-1;
	vertex_list[7].xyz[2]=1;

	face_list[0].bTrangle=false;
	face_list[0].index[0]=0;//上面
	face_list[0].index[1]=3;
	face_list[0].index[2]=2;
	face_list[0].index[3]=1;

	face_list[1].bTrangle=false;
	face_list[1].index[0]=4;//下面
	face_list[1].index[1]=5;
	face_list[1].index[2]=6;
	face_list[1].index[3]=7;

	face_list[2].bTrangle=false;
	face_list[2].index[0]=0;//前面
	face_list[2].index[1]=4;
	face_list[2].index[2]=7;
	face_list[2].index[3]=3;

	face_list[3].bTrangle=false;
	face_list[3].index[0]=1;//后面
	face_list[3].index[1]=2;
	face_list[3].index[2]=6;
	face_list[3].index[3]=5;

	face_list[4].bTrangle=false;
	face_list[4].index[0]=0;//左面
	face_list[4].index[1]=1;
	face_list[4].index[2]=5;
	face_list[4].index[3]=4;

	face_list[5].bTrangle=false;
	face_list[5].index[0]=2;//右面
	face_list[5].index[1]=3;
	face_list[5].index[2]=7;
	face_list[5].index[3]=6;
	///计算每个面上的法向量
	calculateNormals();

}
void pyramid::	draw()
{
	int findex;
	texture=new GLTexture();
	texture->Load("data/NO1.bmp");
	texture->Use();
	glEnable(GL_TEXTURE_2D);
	glBegin(GL_QUADS);
	for(findex=0;findex<face_count;findex++)
	{

		//定义法向量

		glNormal3fv(face_list[findex].xyz);
		glTexCoord2f(0.0f,0.0f);
		glVertex3fv(vertex_list[face_list[findex].index[0]].xyz);
		glTexCoord2f(1.0f,0.0f);
		glVertex3fv(vertex_list[face_list[findex].index[1]].xyz);
		glTexCoord2f(1.0f,1.0f);
		glVertex3fv(vertex_list[face_list[findex].index[2]].xyz);
		glTexCoord2f(0.0f,1.0f);
		glVertex3fv(vertex_list[face_list[findex].index[3]].xyz);
	}
	glEnd();
	glFlush();
	glDisable(GL_TEXTURE_2D);

}
pyramid::~pyramid(void)
{
	if(vertex_list!=NULL) delete vertex_list;
	if(face_list!=NULL) delete face_list;
		if(texture) delete texture;
}

void pyramid::calculateNormal(float*out, float*a, float*b, float*c)
{
	float v1[3], v2[3];

	// calculate two vectors from the three points 
	v1[0] = a [0]- b[0];
	v1[1] = a [1]- b[1];
	v1[2] = a [2]- b[2];

	v2[0] = b [0]- c[0];
	v2[1] = b [1]- c[1];
	v2[2] = b [2]- c[2];
	
	// take the cross product  
	out[0] = v1[1]*v2[2] - v1[2]*v2[1]; 
	out[1] = v1[2]*v2[0] - v1[0]*v2[2]; 
	out[2] = v1[0]*v2[1] - v1[1]*v2[0]; 

	// normalize result 
	float length=sqrt(out[0]*out[0]+out[1]*out[1]+out[2]*out[2]);
	out[0] /= length; 
	out[1] /= length; 
	out[2] /= length; 

}

void pyramid::calculateNormals()
{
	// first, calculate the normal for each face 
	for (unsigned int i=0; i<face_count; i++)
	{
		calculateNormal( face_list[i].xyz,							// <--- receiver
			vertex_list[face_list[i].index[0]].xyz,	// <--- first vertex
			vertex_list[face_list[i].index[1]].xyz,	// <--- second vertex
			vertex_list[face_list[i].index[2]].xyz ); 	// <--- third vertex
	}

}
