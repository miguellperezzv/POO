package aleatorio;

public class Aleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeros[] = new int[6];
		numeros[0]=0;
		for(int i=1; i<6; i++){
			
			numeros[i]= (int)(Math.random()*43)+1; 
			if (numeros[i]==numeros[i-1]){
				do{numeros[i]=(int)(Math.random()*43)+1; }while(numeros[i]==numeros[i-1]);
			}
		}
			
		 for(int i=0;i<6-1;i++)  {

             int min=i;
                  for(int j=i+1; j<6; j++)     {
                      if(numeros[j]<numeros[min])      {
                      min=j;}
                                             }
                 if(i!=min){
                      int aux =numeros[i];
                      numeros[i]=numeros[min];
                      numeros[min] = aux;}
		
		}
		
		   
	          
	          
	  
	          
	      
	    		  for(int i=0; i<numeros[1]-1; i++){
	    			  System.out.print("-");
	    		  }
	    		  System.out.print("X");
	    		  for(int i=0; i<(numeros[2]-numeros[1])-1; i++){
	    			  System.out.print("-");
	    		  }
	    		  System.out.print("X");
	    		  for(int i=0; i<(numeros[3]-numeros[2])-1; i++){
	    			  System.out.print("-");
	    		  }
	    		  System.out.print("X");
	    		  for(int i=0; i<(numeros[4]-numeros[3])-1; i++){
	    			  System.out.print("-");
	    		  }
	    		  System.out.print("X");
	    		  for(int i=0; i<(numeros[5]-numeros[4])-1; i++){
	    			  System.out.print("-");
	    		  }
	    		  System.out.print("X");
	    		  for(int i=0; i<(43-numeros[5]); i++){
	    			  System.out.print("-");
	    		  }
	    		  
	    		  
	    		  System.out.print("  ");
	    		  for(int k=0; k<6;k++)

	  	            System.out.print(numeros[k] + ",");
	    		  }
	
	    		  
	    }
		
		
	
	
	

	


