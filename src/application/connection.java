package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class connection {

    String fileName = "OS_Lab.txt";
    Scanner x;

    public void writeToFile(String d) throws IOException {
        FileWriter file = new FileWriter(fileName);
        BufferedWriter w = new BufferedWriter(file);
        w.write(d);
        w.write("\n");
        w.close();
    }
    
    
    public void FCFS(int at[],int bt[]) {
    	int wt[]=new int[at.length];
    	int tat[]=new int[at.length];
    	float tatA,wtA;
    	tatA=wtA=0f;
    	wt[0]=0;
    	tat[0]=bt[0];
    	
    	for(int i=1;i<wt.length;i++) {
    		wt[i]=(at[i-1]+wt[i-1]+bt[i-1])-at[i];
    		if(wt[i]<0) {
    			wt[i]=0;
    		}
    		tat[i]=wt[i]+bt[i];
    	}
    	for(int j=0;j<wt.length;j++) {
    		tatA+=tat[j];
    		wtA+=wt[j];
    	}
    	tatA/=tat.length;
    	wtA/=wt.length;
    	
    	
    	String data="AT\t|\tBT\t|\tWT\t|\tTAT";
    	for(int i =0;i<at.length;i++) {
    		data+="\n"+at[i]+"\t|\t"+bt[i]+"\t|\t"+wt[i]+"\t|\t"+tat[i];
    	}
    	data+="\n\nAverage Waiting Time: "+wtA;
    	data+="\nAverage Turnaround Time: "+tatA;
    	
    	try {
			writeToFile(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    public void SJF(int at[],int bt[],int pN[]) {
    	
        int wt []= new int[bt.length];
        int tat []= new int[bt.length];
        float wtA = 0, tatA = 0;

       
        wt[0]=0;
    	tat[0]=bt[0];
        int timer=at[0]+bt[0];
        
    	for(int i=1;i<wt.length;i++) {
    		for(int j=i;j<wt.length;j++) {
    			for(int k=i;k<wt.length-1;k++) {
    				if(at[k]<=timer && at[k+1]<=timer) {
    					if(bt[k]>bt[k+1]) {
    						int temp=at[k];
    						at[k]=at[k+1];
    						at[k+1]=temp;
    						
    						temp=bt[k];
    						bt[k]=bt[k+1];
    						bt[k+1]=temp;
    						
    						temp=pN[k];
    						pN[k]=pN[k+1];
    						pN[k+1]=temp;
    					}
    				}
    			}
    		}
    		wt[i]=timer-at[i];
    		if(wt[i]<0) {
    			wt[i]=0;
    		}
    		timer+=bt[i];
    		tat[i]=timer-at[i];
    	}
    	for(int j=0;j<wt.length;j++) {
    		tatA+=tat[j];
    		wtA+=wt[j];
    	}
    	tatA/=tat.length;
    	wtA/=wt.length;
    	
    	
    	String data="PN\t|\tAT\t|\tBT\t|\tWT\t|\tTAT";
    	for(int i =0;i<bt.length;i++) {
    		data+="\n"+pN[i]+"\t|\t"+at[i]+"\t|\t"+bt[i]+"\t|\t"+wt[i]+"\t|\t"+tat[i];
    	}
    	data+="\n\nAverage Waiting Time: "+wtA;
    	data+="\nAverage Turnaround Time: "+tatA;
    	
    	try {
			writeToFile(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    public void RR(int bt[],int ts) {
             int max,temp=0; 
             float wtA=0,tatA=0;
             int wt []=new int[bt.length],
            		 tat[]=new int [bt.length],
            		 tempBT[]=new int[bt.length];
             
                 max=bt[0];
              for(int i=0;i<bt.length;i++) {
            	  tempBT[i]=bt[i];
                if(max<bt[i]) {
                 max=bt[i];
                }
              }
      for(int j=0;j<(max/ts)+1;j++) {
    	  for(int i=0;i<bt.length;i++) {
             if(tempBT[i]!=0) {
            	 if(tempBT[i]<=ts){
            		 tat[i]=temp+tempBT[i];
            		 temp=temp+tempBT[i];
            		 tempBT[i]=0;
            	 }
            	 else{
            		 tempBT[i]=tempBT[i]-ts;
            		 temp=temp+ts;
            	 }
             }
    	  }
     }
     for(int i=0;i<bt.length;i++){
           wt[i]=tat[i]-bt[i];
           if(wt[i]<0) {
   			wt[i]=0;
   		}
           tatA+=tat[i];
            wtA+=wt[i];
     }
     tatA/=tat.length;
 	wtA/=wt.length;
 	
 	
 	String data="BT\t|\tWT\t|\tTAT";
 	for(int i =0;i<bt.length;i++) {
 		data+="\n"+bt[i]+"\t|\t"+wt[i]+"\t|\t"+tat[i];
 	}
 	
 	data+="\n\nTime Slice: "+ts;
 	data+="\nAverage Waiting Time: "+wtA;
 	data+="\nAverage Turnaround Time: "+tatA;
 	
 	try {
			writeToFile(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    
public void PriorityNP(int at[],int bt[],int pN[],int priority[],String pLevel) {
    	
        int wt []= new int[bt.length];
        int tat []= new int[bt.length];
        float wtA = 0, tatA = 0;
        
        
        wt[0]=0;
    	tat[0]=bt[0];
    	int timer=at[0]+bt[0];
    	
    	
    	for(int i=1;i<wt.length;i++) {
    		for(int j=i;j<wt.length;j++) {
    			for(int k=i;k<wt.length-1;k++) {
    				if(at[k]<=timer && at[k+1]<=timer) {
    					if(pLevel=="Lower Number = Higher Priority") {
    						if(priority[k]>priority[k+1]) {
        						int temp=at[k];
        						at[k]=at[k+1];
        						at[k+1]=temp;
        						
        						temp=bt[k];
        						bt[k]=bt[k+1];
        						bt[k+1]=temp;
        						
        						temp=priority[k];
                				priority[k]=priority[k+1];
                				priority[k+1]=temp;
        						
        						temp=pN[k];
        						pN[k]=pN[k+1];
        						pN[k+1]=temp;
        					}
    					}
    					else {
    						if(priority[k]<priority[k+1]) {
        						int temp=at[k];
        						at[k]=at[k+1];
        						at[k+1]=temp;
        						
        						temp=bt[k];
        						bt[k]=bt[k+1];
        						bt[k+1]=temp;
        						
        						temp=priority[k];
                				priority[k]=priority[k+1];
                				priority[k+1]=temp;
        						
        						temp=pN[k];
        						pN[k]=pN[k+1];
        						pN[k+1]=temp;
        					}
    					}
    					
    				}
    			}
    		}
    		wt[i]=timer-at[i];
    		if(wt[i]<0) {
    			wt[i]=0;
    		}
    		timer+=bt[i];
    		tat[i]=timer-at[i];
    	}
    	
    	
    	for(int j=0;j<wt.length;j++) {
    		tatA+=tat[j];
    		wtA+=wt[j];
    	}
    	tatA/=tat.length;
    	wtA/=wt.length;
    	
    	
    	String data="PN\t|\tPriority\t\t|\tAT\t|\tBT\t|\tWT\t|\tTAT";
    	for(int i =0;i<bt.length;i++) {
    		data+="\n"+pN[i]+"\t|\t\t"+priority[i]+"\t\t|\t"+at[i]+"\t|\t"+bt[i]+"\t|\t"+wt[i]+"\t|\t"+tat[i];
    	}
    	data+="\n\nAverage Waiting Time: "+wtA;
    	data+="\nAverage Turnaround Time: "+tatA;
    	
    	try {
			writeToFile(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }



public void PriorityP(int bt[],int pN[],int priority[]) {
	
    int wt []= new int[bt.length];
    int tat []= new int[bt.length];
    float wtA = 0, tatA = 0;
    
    wt[0]=0;
	tat[0]=bt[0];
	
	for(int i=1;i<wt.length;i++) {
		wt[i]=wt[i-1]+bt[i-1];
		if(wt[i]<0) {
			wt[i]=0;
		}
		tat[i]=wt[i]+bt[i];
	}
    
	
	
	for(int j=0;j<wt.length;j++) {
		tatA+=tat[j];
		wtA+=wt[j];
	}
	tatA/=tat.length;
	wtA/=wt.length;
	
	
	String data="PN\t|\tPriority\t\t|\tBT\t|\tWT\t|\tTAT";
	for(int i =0;i<bt.length;i++) {
		data+="\n"+pN[i]+"\t|\t\t"+priority[i]+"\t\t|\t"+bt[i]+"\t|\t"+wt[i]+"\t|\t"+tat[i];
	}
	data+="\n\nAverage Waiting Time: "+wtA;
	data+="\nAverage Turnaround Time: "+tatA;
	
	try {
		writeToFile(data);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
    
    
}
    
    


