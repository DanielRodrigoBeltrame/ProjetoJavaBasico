import java.util.List;

import builders.StudentsBuilder;
import entities.Studant;
import services.StudantService;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        var allStudents = StudentsBuilder.getAllStudents();
        var averageMin = 7.0;
        
        /* 
         * 1. Recupere da lista os alunos que passaram de ano (nota minima 7.0).
            - Exiba os dados nesse formato: <código> - <nome> : Média = <nota> */
        System.out.println();
        System.out.println("Exercicio 1:");
        System.out.println("Lista dos alunos que passaram de ano: ");
        listStudentsApproved(allStudents, averageMin);
        
        /* 
         * 2. Recupere da lista os alunos que não passaram de ano.
            - Exiba os dados nesse formato: <código> - <nome> : Média = <media> (Faltou = <nota_faltante>) */
        separaExercicios();
        System.out.println("Exercicio 2:");
        System.out.println("Lista dos alunos que não passaram de ano: ");
        listaStudentsFailed(allStudents, averageMin);
        
        /* 
         * 3. Traga os alunos que tiraram a nota máxima (nota 10).
            - Exiba os dados nesse formato: <código> - <nome> */
        separaExercicios();
        System.out.println("Exercicio 3:");
        System.out.println("Alunos que tiraram a nota máxima: ");
		studentsValueMax(allStudents);
		
        /* 
         * 4. Traga o aluno que tirou a menor nota, em caso de notas iguais, traga ambos os alunos.
            - Exiba os dados nesse formato: <código> - <nome> : Nota = <nota> 
            */
        separaExercicios();
        System.out.println("Exercicio 4:");
        System.out.println("Aluno(os) com a menor nota: ");
        studentsValueMin(allStudents);

        /*   
         *  5. Faça uma lista com top 3 notas de alunos. Em caso de notas iguais coloque todos na mesma posição.
            - Ex:
                1º - Fulano : Nota = 10.0;
                   - Beltrano : Nota = 10.0;
                2º - Joãozinho : Nota = 9.0;
                3º - Mariazinha : Nota = 8.9;
            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
            */
        separaExercicios();
        System.out.println("Exercicio 5:");
        System.out.println("Top 3 maiores notas de alunos: ");
        rankMaxValue(allStudents);
		
		/**
		 * 6. Faça uma lista com as 3 menores notas de alunos. Em caso de notas iguais coloque todos na mesma posição. Exemplo igual a anterior
            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
		 */
		separaExercicios();
		System.out.println("Exercicio 6:");
		System.out.println("Top 3 menores notas de alunos: ");
		rankMinValue(allStudents);
		
        /**
         * 7. Monte a média de todos os alunos e exiba em tela ordenando da maior para a menor nota.
            - Exiba os dados nesse formato: <posicao> - <código> - <nome> : Média = <nota>
         */
		separaExercicios();
		System.out.println("Exercicio 7:");
		System.out.println("Classificação de alunos por media: ");
		rankAverageValue(allStudents);
		
    }

	private static void rankAverageValue(List<Studant> allStudents) {
		List<StudantService> allStudentsAverageValue = new ArrayList<>();
        
        for(Studant oneStudent : allStudents) {
        	var average = (oneStudent.getTestOne() + oneStudent.getTestTwo() + oneStudent.getTestThree())/3;
        	allStudentsAverageValue.add(new StudantService(oneStudent.getCode(), oneStudent.getName(), average));
			
        }
        
        allStudentsAverageValue.sort(Comparator.comparing(StudantService::getValue).reversed());
        
        var classification = 0;
        var minValue = 0.0;
        for(StudantService oneStundet : allStudentsAverageValue) {
        	
        	if(oneStundet.getValue() != minValue) {
        		minValue = oneStundet.getValue();
        		classification ++;
        	}
        	System.out.println( classification + "º - " + oneStundet.getCode() + " - " + oneStundet.getName() + ": Nota = " + oneStundet.getValue());
        	
        }
	}

	private static void rankMinValue(List<Studant> allStudents) {
		List<StudantService> allStudentsMinValue = new ArrayList<>();
        
        for(Studant oneStudent : allStudents) {
			
        	if((oneStudent.getTestOne() < oneStudent.getTestTwo()) && (oneStudent.getTestOne() < oneStudent.getTestThree())) {
        		allStudentsMinValue.add(new StudantService(oneStudent.getCode(), oneStudent.getName(), oneStudent.getTestOne()));
        	}else if (oneStudent.getTestTwo() < oneStudent.getTestThree()) {
        		allStudentsMinValue.add(new StudantService(oneStudent.getCode(), oneStudent.getName(), oneStudent.getTestTwo()));
			} else {
				allStudentsMinValue.add(new StudantService(oneStudent.getCode(), oneStudent.getName(), oneStudent.getTestThree()));
			}
        }
        allStudentsMinValue.sort(Comparator.comparing(StudantService::getValue));
        
        var classification = 0;
        var minValue = 0.0;
        for(StudantService oneStundet : allStudentsMinValue) {
        	
        	if(oneStundet.getValue() != minValue) {
        		minValue = oneStundet.getValue();
        		classification ++;
        	}
        	if(classification <= 3) {
        		System.out.println( classification + "º - " + oneStundet.getName() + ": Nota = " + oneStundet.getValue());
        	}
        	
        }
	}

	private static void rankMaxValue(List<Studant> allStudents) {
		List<StudantService> allStudentsMaxNota = new ArrayList<>();
        
        for(Studant oneStudent : allStudents) {
			
        	if((oneStudent.getTestOne() > oneStudent.getTestTwo()) && (oneStudent.getTestOne() > oneStudent.getTestThree())) {
        		allStudentsMaxNota.add(new StudantService(oneStudent.getCode(), oneStudent.getName(), oneStudent.getTestOne()));
        	}else if (oneStudent.getTestTwo() > oneStudent.getTestThree()) {
        		allStudentsMaxNota.add(new StudantService(oneStudent.getCode(), oneStudent.getName(), oneStudent.getTestTwo()));
			} else {
				allStudentsMaxNota.add(new StudantService(oneStudent.getCode(), oneStudent.getName(), oneStudent.getTestThree()));
			}
        }
        allStudentsMaxNota.sort(Comparator.comparing(StudantService::getValue).reversed());
        
        var classification = 0;
        var maxValue = 0.0;
        for(StudantService oneStundet : allStudentsMaxNota) {
        	
        	if(oneStundet.getValue() != maxValue) {
        		maxValue = oneStundet.getValue();
        		classification ++;
        	}
        	if(classification <= 3) {
        		System.out.println( classification + "º - " + oneStundet.getName() + ": Nota = " + oneStundet.getValue());
        	}
        }
	}

	private static void studentsValueMin(List<Studant> allStudents) {
		List<Float> litValue = new ArrayList<>();
        for(Studant oneStudent : allStudents) {
        	litValue.add(oneStudent.getTestOne());
        	litValue.add(oneStudent.getTestTwo());
        	litValue.add(oneStudent.getTestThree());
        }
        
        litValue.sort(null);
        var lowestValue = litValue.get(0);
        
		for(Studant oneStudent : allStudents) {
			if(oneStudent.getTestOne() <= lowestValue) {
				System.out.println(oneStudent.getCode() + " - " + oneStudent.getName() + " - Nota = " + oneStudent.getTestOne());
			}else if(oneStudent.getTestTwo() <= lowestValue) {
				System.out.println(oneStudent.getCode() + " - " + oneStudent.getName() + " - Nota = " + oneStudent.getTestTwo());
			}else if(oneStudent.getTestThree() <= lowestValue) {
				System.out.println(oneStudent.getCode() + " - " + oneStudent.getName() + " - Nota = " + oneStudent.getTestThree());
			}
        }
	}

	private static void studentsValueMax(List<Studant> allStudents) {
		for(Studant oneStudent : allStudents) {
			if((oneStudent.getTestOne() == 10) || (oneStudent.getTestTwo() == 10) || (oneStudent.getTestThree() == 10)) {
				System.out.println(oneStudent.getCode() + " - " + oneStudent.getName());
			}
        }
	}

	private static void listaStudentsFailed(List<Studant> allStudents, double averageMin) {
		for(Studant oneStudent : allStudents) {
        	
        	var average = (oneStudent.getTestOne() + oneStudent.getTestTwo() + oneStudent.getTestThree())/3;
        	var missed = averageMin - average;
        	if(average < averageMin) {
        		System.out.println(oneStudent.getCode() + " - " + oneStudent.getName() + ": " + " Media = " + average  + " Faltou = " + missed);
        	}
        }
	}

	private static void listStudentsApproved(List<Studant> allStudents, double averageMin) {
		
        for(Studant oneStudent : allStudents) {
        	
        	var average = (oneStudent.getTestOne() + oneStudent.getTestTwo() + oneStudent.getTestThree())/3;
        	if(average >= averageMin) {
        		System.out.println(oneStudent.getCode() + " - " + oneStudent.getName() + ": " + " Media = " + average);
        	}
        }
	}
	
	private static void separaExercicios() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println();
	}
}
