import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gr.spinellis.ckjm.MetricsFilter;

public class Main {

	public static void main(String[] args) {
		// WMC, DIT, NOC, CBO, RFC, LCOM, Ce, and NPM.
		String classpath = "D:\\70_codereview\\eclipse\\workspace_redca\\CKMetrics_Test\\bin\\";
		
		String wmc = classpath + "wmc";
		String dit = classpath + "dit";
		String noc = classpath + "noc";
		String cbo = classpath + "cbo";
		String rfc = classpath + "rfc";
		String lcom= classpath + "lcom";
		
		String[] arguments = getArguments(lcom);
		MetricsFilter.main(arguments);
	}

	private static String[] getArguments(String... args) {
		List<String> fileList = new ArrayList<>();
		for(String path : args){
			File file = new File(path);
			if(file.isDirectory()){
				for(String f : file.list()){
					fileList.add(path + "\\" + f);
				}
			}else if(file.isFile()){
				fileList.add(path);
			}
		}
		String[] results = fileList.toArray(new String[fileList.size()]);
		return results;
	}
}
