//Program to Find the busiest period in the building, that is, the time with the most people in the building
import java.util.*;
import java.lang.*;
public class Busiesttime {
public static void main(String[] args) {


Scanner scan=new Scanner(System.in);
int n=scan.nextInt();
long[][] vis= new long[n][3];
int i=0, j=0;
for(i=0; i<n; i++){ // taking values
	for(j=0; j<3; j++){
		if(j!=2)
		vis[i][j] = scan.nextInt();
	if(j==2){
		String entry=scan.next();
		if(entry.equals("enter"))
		vis[i][j]=1;
		else
			vis[i][j]=0;
	}
	}
}
for(i=0; i<n; i++){ // printing values
	for(j=0; j<3; j++){
		System.out.print(vis[i][j] + " ");
	}
	System.out.println();
}

//Logic starts
long count[]=new long[n];
int k=0;
Boolean check = true;
if(vis[0][2] == 1)
	check = true;
else check = false;
//Storing the counts based on entries
count[0] = check?(count[0]+vis[0][1]):(count[0]-vis[0][1]);
System.out.println("First count " + count[k]);
k=1;
for(i=1; i<n; i++){ 
	if(vis[i][2] == 1){
		count[k] = count[k-1] + vis[i][1];
		System.out.println("Next count: " + count[k]);
	}
	else{
		count[k]= count[k-1]-vis[i][1];
		System.out.println("Next count: " +count[k]);
	}
	k++;
}
for(long mycount : count)
System.out.println("Total counts : " + mycount);

long max = 0;
int index=0;
int newindex=0;
int f=0;
//Finding max count
for(i=0; i<n; i++){
		if(count[i]>max){
			max = count[i];
			index = i;
		}
		
}
//if count remains constant
for(j=index+1; j<n; j++){
		if(max == count[j]){
			newindex=j;
			f=1;
		}
		}
if(f==0)
System.out.println("Maximum time period : " + vis[index][0] + "    " + vis[index + 1][0]);
else
	System.out.println("Maximum time period : " + vis[index][0] + "    " + vis[newindex+1][0]);
}
}
