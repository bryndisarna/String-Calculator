package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains("\n")){
			return sum(splitNewLine(text));
		}
		else if (text.contains("\n,") || text.contains ",\n"){
			return null;
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}

	private static int splitNewline(String numbers){
		return numbers.split("\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    String allNegatives;

        for(String number : numbers){

        	if(toInt(number) > 0 && toInt(number) <= 1000){
				 total += toInt(number);
			}
		    
		    else if(toInt(number) < 0){
		    	if(!allNegatives.isEmpty()){
					
					allNegatives = allNegatives + "," + number;
				}
				else 
					allNegatives += number;
				}

			if(toInt(number) < 0){
				throw new IllegalArgumentException(allNegatives);
			}

		}

		return total;
    }



}