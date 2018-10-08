
public class Tester {

	public static void main(String args[]){
		Network tests = new Network();
		
		
		//Single path
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[1];
		C[0] = "B";
		tests.addInput("A", A, 1);
		tests.addInput("B", B, 2);
		tests.addInput("C", C, 3);
		
		
		/*
		//Split
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[1];
		C[0] = "B";
		String[] D = new String[1];
		D[0] = "B";
		tests.addInput("A", A, 1);
		tests.addInput("B", B, 2);
		tests.addInput("C", C, 3);
		tests.addInput("D", D, 2);
		*/
		
		/*
		//Split + Merge
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[1];
		C[0] = "B";
		String[] D = new String[1];
		D[0] = "A";
		String[] E = new String[1];
		E[0] = "B";
		String [] F = new String[2];
		F[0] = "D";
		F[1] = "E";
		tests.addInput("A", A, 1);
		tests.addInput("B", B, 2);
		tests.addInput("C", C, 7);
		tests.addInput("D", D, 4);
		tests.addInput("E", E, 1);
		tests.addInput("F", F, 1);
		*/
		
		/*
		//Single Path(random order)
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[1];
		C[0] = "B";
		tests.addInput("C", C, 3);
		tests.addInput("A", A, 1);
		tests.addInput("B", B, 2);
		*/
		
		/*
		//Split (random order)
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[1];
		C[0] = "B";
		String[] D = new String[1];
		D[0] = "B";
		tests.addInput("B", B, 2);
		tests.addInput("A", A, 1);
		tests.addInput("D", D, 2);
		tests.addInput("C", C, 3);
		*/
		
		/*
		//Split + Merge (random order)
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[1];
		C[0] = "B";
		String[] D = new String[1];
		D[0] = "A";
		String[] E = new String[1];
		E[0] = "B";
		String [] F = new String[2];
		F[0] = "D";
		F[1] = "E";
		tests.addInput("F", F, 1);
		tests.addInput("C", C, 7);
		tests.addInput("B", B, 2);
		tests.addInput("D", D, 4);
		tests.addInput("A", A, 1);
		tests.addInput("E", E, 1);
		*/
		
		/*
		//Restart
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[1];
		C[0] = "B";
		String[] D = new String[1];
		D[0] = "A";
		String[] E = new String[1];
		E[0] = "B";
		String [] F = new String[2];
		F[0] = "D";
		F[1] = "E";
		tests.addInput("C", C, 7);
		tests.addInput("B", B, 2);
		tests.addInput("D", D, 4);
		tests.addInput("A", A, 1);
		tests.addInput("E", E, 1);
		
		System.out.println(tests.process());
		
		tests.restart();
		System.out.println("restarted");
		
		tests.addInput("F", F, 1);
		tests.addInput("C", C, 7);
		tests.addInput("B", B, 2);
		tests.addInput("D", D, 4);
		tests.addInput("A", A, 1);
		tests.addInput("E", E, 1);
		//the process function is called at the end of code
		*/
		
		
		/*
		//Error checking (Cycle 1)
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[2];
		C[0] = "B";
		C[1] = "D";
		String[] D = new String[1];
		D[0] = "C";
		tests.addInput("A", A, 1);
		tests.addInput("B", B, 2);
		tests.addInput("C", C, 3);
		tests.addInput("D", D, 2);
		*/
		
		/*
		//Error checking (Cycle 2)
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[2];
		B[0] = "A";
		B[1] = "D";
		String[] C = new String[1];
		C[0] = "B";
		String[] D = new String[1];
		D[0] = "C";
		tests.addInput("A", A, 1);
		tests.addInput("B", B, 2);
		tests.addInput("C", C, 3);
		tests.addInput("D", D, 2);
		*/
		
		/*
		//Error checking(Cycle 3)
		String[] A = new String[1];
		A[0] = null;
		String[] B = new String[1];
		B[0] = "A";
		String[] C = new String[2];
		C[0] = "A";
		C[1] = "E";
		String[] D = new String[1];
		D[0] = "C";
		String[] E = new String[1];
		E[0] = "D";
		tests.addInput("A", A, 1);
		tests.addInput("B", B, 2);
		tests.addInput("C", C, 3);
		tests.addInput("D", D, 2);
		tests.addInput("E", E, 1);
		*/
		
		/*
		//Error checking(only one input)
		String[] A = new String[1];
		A[0] = null;
		tests.addInput("A", A, 1);
		*/
		
		//Error Checking(no input) - just don't put anything
		
		System.out.println(tests.process());
	}
	
}
