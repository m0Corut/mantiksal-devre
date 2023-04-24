import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class _21010310014_KarnaughManager {
	
	private Scanner in;
	private String degisken[];
	private String dogrulukTablosu[][];
	
	
		public _21010310014_KarnaughManager(File file) throws FileNotFoundException {
			in=new Scanner(file);
			System.out.println(file.getName()+" dosyası okundu.");
	}
		
		public void readFile()  {
		
		String[] temp=in.nextLine().split(":");
		temp=temp[1].split(",");
		
		for (int i = 0; i < temp.length; i++) {
			temp[i]=temp[i].trim();
		}
		
		
		degisken=Arrays.copyOf(temp, temp.length+1);
		
		degisken[temp.length]="F";
		in.nextLine();
		
		int satirSayisi=(int)Math.pow(2, degisken.length-1);
		int sutunSayisi=degisken.length;
				
		dogrulukTablosu=new String[satirSayisi][sutunSayisi];
			  
		
		for (int i = 0; i < satirSayisi; i++) {
			
			int deger=i;
			for (int j = sutunSayisi-2; j >= 0; j--) {
				
				if (deger % 2 == 1) {	
					
					dogrulukTablosu[i][j] = "1";
                    } 
				
				else {
                	
					dogrulukTablosu[i][j] = "0";
                }
               
				deger/= 2;
				
			}
			
		}

		int j=0;
		while (in.hasNextLine()) {
			
			if(j==8) {
					j=12;
					
				}
				
				else if(j==16) {
					j=8;

				}
			
			String[] deger=in.nextLine().split(" ");
			swap(deger,2,3);
			
			
			for (int i = 0; i < 4; i++) {
				
				dogrulukTablosu[i+j][sutunSayisi-1]=deger[i];
				
			}
			j=j+4;
			
			
		}
		
	}
		
	
	private void minTerimToplam(String ifade) {
		
		String minterimToplam="";
		
		for (int i = 0; i < dogrulukTablosu.length; i++) {
			
			int j=0;
			while(dogrulukTablosu[i][degisken.length-1].equals(ifade)&&j<degisken.length-1) {
			
				if(dogrulukTablosu[i][j].equals("1")) {
					minterimToplam=minterimToplam+degisken[j];
				}
				else {
					minterimToplam=minterimToplam+degisken[j]+"'";
				}
				j++;
			}
			
			if(dogrulukTablosu[i][degisken.length-1].equals(ifade)) {
				minterimToplam=minterimToplam+" + ";	
			}
			
		}
			minterimToplam=minterimToplam.substring(0,minterimToplam.length()-2);
			
			if(ifade.equals("1"))
			System.out.println("Min Terimler Toplamı F= "+minterimToplam);
			
			else 
				System.out.println("Tümleyenin Min Terimler Toplamı F'= "+minterimToplam);

			
	}
		
		private void maxTerimCarpim(String ifade) {
			
			String maxTerimCarpim="";
					
			
			for (int i = 0; i < dogrulukTablosu.length; i++) {
				
			int j=0;	
			
			if(dogrulukTablosu[i][degisken.length-1].equals(ifade)) {
				maxTerimCarpim=maxTerimCarpim+"(";	
			}	
			
			while(dogrulukTablosu[i][degisken.length-1].equals(ifade)&&j<degisken.length-1) {
				
				if(dogrulukTablosu[i][j].equals("1")) {
					maxTerimCarpim=maxTerimCarpim+degisken[j]+"'";
				}
				else {
						maxTerimCarpim=maxTerimCarpim+degisken[j];
				}
				
				if(j<degisken.length-2)
					maxTerimCarpim=maxTerimCarpim+" + ";		
				j++;
			}
			
			if(dogrulukTablosu[i][degisken.length-1].equals(ifade)) {
				
				maxTerimCarpim=maxTerimCarpim+").";	
			}
			
		}
			maxTerimCarpim=maxTerimCarpim.substring(0,maxTerimCarpim.length()-1);
			
			if(ifade.equals("0"))
				System.out.println("Max Terimler Carpımı F= "+maxTerimCarpim);
				
				else 
					System.out.println("Tümleyenin Max Terimler Carpımı F'= "+maxTerimCarpim);

				
			
		}	
						
		public void printMinTerimToplam() {
			minTerimToplam("1");
			
			
		}
		
		public void printTumleyenMinTerimToplam() {
			minTerimToplam("0");
			
			
		}
		public void printMaxTerimCarpımı() {
			maxTerimCarpim("0");
			
		}
		
		public void printTumleyenMaxTerimCarpımı() {
			maxTerimCarpim("1");
			
		}
	
	
	public void yazdir() {
		
		System.out.println("doğruluk tablosu:");
		for (int i = 0; i < degisken.length; i++) {
			System.out.print(degisken[i]+" ");
		}
		System.out.println();
	
		for (int i = 0; i < dogrulukTablosu.length; i++) {
			for (int j = 0; j < dogrulukTablosu[0].length; j++) {
				System.out.print(dogrulukTablosu[i][j]+" ");
			}
			System.out.println();
		}

		
		
		System.out.println("fonksiyon ifadeleri:");
	}
	
	private void swap(String[] arr,int i ,int j) {
		String temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
}
	
	public Scanner getIn() {
		return in;
	}

	public void setIn(Scanner in) {
		this.in = in;
	}

	public String[][] getDogrulukTablosu() {
		return dogrulukTablosu;
	}

	public void setDogrulukTablosu(String[][] dogrulukTablosu) {
		this.dogrulukTablosu = dogrulukTablosu;
	}


	public String[] getDegisken() {
		return degisken;
	}
	public void setDegisken(String[] degisken) {
		this.degisken = degisken;
	}
	

}
