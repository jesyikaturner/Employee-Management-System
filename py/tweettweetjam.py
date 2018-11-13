from random import randint as v
def P(m,s):
  print("Score: ",s)
  for r in m:
    for c in r:
      print(c,end=" ")
    print()
def R(map,G):
  b[v(0,3)][v(0,3)]=G
X,E,G='X','-','O';x,y,pX,pY=0,0,0,0;s=0;b=[[E]*4 for _ in range(4)];b[y][x]=X;R(b,G);P(b,s);
while(True):
  c='';
  while c.lower() not in {'w','a','s','d'}:c=input("WASD? ")
  if(y+1>0 and y<4 and x+1>0 and x<4):
    if c=='w':y-=1
    if c=='s':y+=1
    if c=='a':x-=1
    if c=='d':x+=1
    if b[y][x]==G:s+=1;R(b,G)
    b[y][x]=X;b[pY][pX]=E;pY,pX=y,x;
  P(b,s)







