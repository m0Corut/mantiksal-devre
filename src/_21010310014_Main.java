import java.io.File;
import java.io.FileNotFoundException;

public class _21010310014_Main {

	public static void main(String[] args) throws FileNotFoundException {

		
		
		_21010310014_KarnaughManager karno=new _21010310014_KarnaughManager(new File("karnaugh2.txt"));
		
		karno.readFile();
	
		karno.yazdir();
		
		karno.printMinTerimToplam();
		karno.printMaxTerimCarpımı();
		karno.printTumleyenMinTerimToplam();
		karno.printTumleyenMaxTerimCarpımı();
		
		
		
		

	}

}
