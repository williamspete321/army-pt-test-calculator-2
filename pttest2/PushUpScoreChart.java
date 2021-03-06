package pttest2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class PushUpScoreChart {
	private Map<Integer, Integer> pushupScoreChart;
	
	public PushUpScoreChart(Soldier soldier) {
		populatePushUpChart(soldier);
	}
	
    public Map<Integer, Integer> getPushupScoreChart() {
		return pushupScoreChart;
	}

	public void setPushupScoreChart(Map<Integer, Integer> pushupScoreChart) {
		this.pushupScoreChart = pushupScoreChart;
	}

	private void populatePushUpChart(Soldier soldier) {
        // TreeMap to have sorted results
        pushupScoreChart = new TreeMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(
                selectCorrectFile(soldier)))) {
        	
            String line = null;
            while ((line = in.readLine()) != null) {

                String[] data = line.split("\t");

                if (data.length == 2) {
                    int repetitions = Integer.parseInt(data[0]);
                    int score = Integer.parseInt(data[1]);
                    
                    pushupScoreChart.put(repetitions, score);
                }
            }
        }
        catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
    
    private String selectCorrectFile(Soldier soldier) {
    		int age = soldier.getAge();
    		Gender gender = soldier.getGender();
		String fileName = null;
		
		if (gender == Gender.MALE) {
			if (age >= 62) {
				fileName = "MalePU62+.txt";
			} 
			else if (age >= 57) {
				fileName = "MalePU57-61.txt";
			} 
			else if (age >= 52) {
				fileName = "MalePU52-56.txt";
			}
			else if (age >= 47) {
				fileName = "MalePU47-51.txt";
			}
			else if (age >= 42) {
				fileName = "MalePU42-46.txt";
			}
			else if (age >= 37) {
				fileName = "MalePU37-41.txt";
			}
			else if (age >= 32) {
				fileName = "MalePU32-36.txt";
			}
			else if (age >= 27) {
				fileName = "MalePU27-31.txt";
			}
			else if (age >= 22) {
				fileName = "MalePU22-26.txt";
			}
			else {
				fileName = "MalePU17-21.txt";
			}
		} 
		else {
			if (age >= 62) {
				fileName = "FemalePU62+.txt";
			} 
			else if (age >= 57) {
				fileName = "FemalePU57-61.txt";
			} 
			else if (age >= 52) {
				fileName = "FemalePU52-56.txt";
			}
			else if (age >= 47) {
				fileName = "FemalePU47-51.txt";
			}
			else if (age >= 42) {
				fileName = "FemalePU42-46.txt";
			}
			else if (age >= 37) {
				fileName = "FemalePU37-41.txt";
			}
			else if (age >= 32) {
				fileName = "FemalePU32-36.txt";
			}
			else if (age >= 27) {
				fileName = "FemalePU27-31.txt";
			}
			else if (age >= 22) {
				fileName = "FemalePU22-26.txt";
			}
			else {
				fileName = "FemalePU17-21.txt";
			}
		}
		return fileName;
    }

}
