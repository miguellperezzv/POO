import javax.swing.JFrame;

public class Recta extends JFrame{
 int x,y,x1,y1;
 
 Recta(int x, int y, int x1, int y1){
	 this.x=x;
	 this.x1=x1;
	 this.y=y;
	 this.y1=y1;
 }
 

 double pendiente() {
	 if((x-x1)==0) {
		 
		 return 0;
	 }
	 else {
	double m;
	 m=(double)(y1-y)/(x1-x);
	 return m;
	 }
 }
 
 double altura() {
	 
	 return (-this.pendiente()*x1)+y1;
 }
 
 double distancia() {
	
	 return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
 }
 
 void info () {
	 
	 System.out.print("La pendiente es:" +this.pendiente()+"\n");
	 System.out.print("La altura es:" +this.altura()+"\n");
	 System.out.print("La dist es:" +this.distancia()+"\n");
 }
}
