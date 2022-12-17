package legacy;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TennisExplorer {

	public ArrayList<String> fixtureGrab(WebDriver driver, int i, int h, ArrayList<String> links, WebDriverWait wait,
			int startIndex, int endIndex, String day, String month, String year) {

		driver.get("https://www.tennisexplorer.com/next/?type=atp-single&year="+year+"&month="+month+"&day="+day+"&timezone=-7");


		i = startIndex;
		
		
		while (true && i < endIndex) {
			try {

				h = i + 1;
				String fixture = "";
				

					fixture = driver.findElement(By.xpath("//*[@id=\"r"+h+"\"]/td[13]/a")).getAttribute("href");
					links.add(fixture);
					


				

			} catch (Throwable t) {
			//	System.out.println("# links = " + links.size());

				//System.out.println("Not Displayed");
			}

			i++;

		}
		System.out.println("# links = " + links.size());

		return links;

	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// setting the driver executable
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox"); // Bypass OS security model
		options.addArguments("headless"); 
		options.addArguments("--disable-extensions"); // Bypass OS security model
//        options.addArguments("--user-data-dir=C:/Users/PAC/Desktop/p1"); // Bypass OS security model
//
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, 1);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);

		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date1 = new Date(System.currentTimeMillis());
		System.out.println(formatter1.format(date1));
		File file = new File("./tennisBets/tennisBets_" + formatter1.format(date1) + ".csv");

		// Create the file
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}

		Writer myWriter = new FileWriter(file);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ArrayList<String> links = new ArrayList<String>();
		int i = 1;
		int h = 0;
		int linknum = 1;

		TennisExplorer ls = new TennisExplorer ();
		
		links = ls.fixtureGrab(driver, i, h, links, wait, 1, 2000, "12","11","2022");

//		links.add("https://www.tennisexplorer.com/match-detail/?id=2227461");
//		links.add("https://www.tennisexplorer.com/match-detail/?id=2224241");
//		links.add("https://www.tennisexplorer.com/match-detail/?id=2205647");




		
		// Using list iterator
		ListIterator<String> litr = null;
		litr = links.listIterator();

		while (litr.hasNext()) {

			String link = litr.next();
			System.out.println(link);
			driver.get(link);
			System.out.println("link # (" + linknum + " / " + links.size() + ")");
			linknum++;

			boolean neutral = true;

			ArrayList<Integer> homeForm = new ArrayList<Integer>();
			ArrayList<Integer> awayForm = new ArrayList<Integer>();
			

			float neutralHomeFormRecProb = 0, neutralAwayFormRecProb = 0, homeFormRecProb = 0, awayFormRecProb = 0,
					 neutralHomeFormRegProb = 0, neutralAwayFormRegProb = 0, homeFormRegProb = 0, awayFormRegProb = 0;

			String homeName, awayName ,matchResult, matchScore = "", date = "", ranking1 = "", ranking2 = "";	
			
			int rank1, rank2;
				
			try {
			matchScore = driver.findElement(By.xpath("//*[@class='gScore']")).getText();
			}catch(Exception e) {
				matchScore = "";
			}
			
			//*[@id="center"]/div[1]/span
			//*[@id="center"]/div[1]/text()[1]
			
			try {
			date = driver.findElement(By.xpath("(//*[@id=\"center\"]/div[1])[1]")).getText();

			}catch(Exception e) {
				date = "";
				date = "";

			}

			try {


				// get home name

					homeName = driver.findElement(By.xpath("(//*[@class='plName'])[1]")).getText();


				// get away name
					awayName = driver.findElement(By.xpath("(//*[@class='plName'])[2]")).getText();

					
					// get home name

					ranking1 = driver.findElement(By.xpath("//*[@id=\"center\"]/div[2]/table/tbody/tr[1]/td[2]")).getText();

					

				// get away name
					ranking2 = driver.findElement(By.xpath("//*[@id=\"center\"]/div[2]/table/tbody/tr[1]/td[3]")).getText();

					
					ranking1 = ranking1.substring(0, ranking1.length()-1);
					ranking2 = ranking2.substring(0, ranking2.length()-1);
					
					if(ranking1.equals("-"))
						ranking1 = "2000";
					if(ranking2.equals("-"))
						ranking2 = "2000";


					// System.out.println("ranking1 = " + ranking1);

					rank1 = Integer.parseInt(ranking1);
					rank2 = Integer.parseInt(ranking2);

					

				driver.get(link);

				for (int j = 0; j < 1; j++) {

					homeForm.clear();
					awayForm.clear();


					// get home avg
					
					//System.out.println("matchScore = " + matchScore);
					if(matchScore.length() < 5)
					i = 2;
					else
					i = 4;


					while (true) {
						try {
									
								matchResult = driver.findElement(By.xpath(
										"(//*[@class='result mutual'])[1]/tbody/tr["+i+"]/td[1]"))
										.getAttribute("className");


									

							if (matchResult.equals("first icon-result win")) {
								homeForm.add(3);
							}
							else if (matchResult.equals("first icon-result lose")) {
								homeForm.add(0);
							}

//	 						 System.out.println("home form = " + homeForm.get(i-1));
//							 System.out.println("home goals = " + homeGoals.get(i-1));
//							 System.out.println("home opp goals = " + homeOppGoals.get(i-1));
							
							i = i + 2;

						} catch (Exception e) {
//							System.out.println("no more home goals");
							// System.out.println(e.getMessage());
							break;
						}
					}

					
				
					if(matchScore.length() < 5)
					i = 2;
					else
					i = 4;

					
					while (true) {
						try {

							
									
							
								matchResult = driver.findElement(By.xpath(
										"(//*[@class='result mutual'])[2]/tbody/tr["+i+"]/td[1]"))
										.getAttribute("className");


	

							if (matchResult.equals("first icon-result win")) {
								awayForm.add(3);
							}
							else if (matchResult.equals("first icon-result lose")) {
								awayForm.add(0);
							}

//							 System.out.println("away form = " + awayForm.get(i-1));
//							 System.out.println("away goals = " + awayGoals.get(i-1));
//							 System.out.println("away opp goals = " + awayOppGoals.get(i-1));

							i = i + 2;

						} catch (Exception e) {
//							System.out.println("no more away goals");
							// System.out.println(e.getMessage());
							break;
						}
					}

					float homeFormRecAvg = 0, awayFormRecAvg = 0;

					float homeFormRegAvg = 0, awayFormRegAvg = 0;

					float sum3 = 0;


					ArrayList<Float> homeFormRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> awayFormRecAvgArr = new ArrayList<Float>();


					for (i = 0; i < homeForm.size(); i++) {



						sum3 += homeForm.get(i);
						homeFormRecAvgArr.add(sum3 / (i + 1));


					}

					homeFormRegAvg = sum3 / homeForm.size();

					sum3 = 0;
					
					

					for (i = 0; i < homeForm.size(); i++) {

						sum3 += homeFormRecAvgArr.get(i);

					}

					
					homeFormRecAvg = sum3 / homeForm.size();
					
					homeFormRecProb = homeFormRecAvg;


					sum3 = 0;
					



					for (i = 0; i < awayForm.size(); i++) {

			

						sum3 += awayForm.get(i);
						awayFormRecAvgArr.add(sum3 / (i + 1));



					}

					awayFormRegAvg = sum3 / awayForm.size();

				
					sum3 = 0;
					

					for (i = 0; i < awayForm.size(); i++) {

				
						sum3 += awayFormRecAvgArr.get(i);
						

					}

					
					awayFormRecAvg = sum3 / awayForm.size();
				
					
					awayFormRecProb = awayFormRecAvg;

				

					if (neutral) {



						neutralHomeFormRecProb = homeFormRecAvg;
						neutralAwayFormRecProb = awayFormRecAvg;
						neutralHomeFormRegProb = homeFormRegAvg;
						neutralAwayFormRegProb = awayFormRegAvg;


					}

					neutral = false;

				} // h/a for loop



				String homeMaxOddsS = driver.findElement(By.xpath("(//*[@class='average'])[1]/td[2]/div"))
						.getText();
				// grab away odds (min)
				String awayMaxOddsS = driver.findElement(By.xpath("(//*[@class='average'])[1]/td[3]/div"))
						.getText();

				

				float homeAvgOdds = Float.parseFloat(homeMaxOddsS);
				float awayAvgOdds = Float.parseFloat(awayMaxOddsS);



				

				
				

				String betType = "";
				Integer exception = 0;
				float formDiffReg = (neutralHomeFormRegProb - neutralAwayFormRegProb);
				float minRegForm = Math.min(neutralHomeFormRegProb, neutralAwayFormRegProb);
				float maxRegForm = Math.max(neutralHomeFormRegProb, neutralAwayFormRegProb);

				float homeFormOdds = neutralHomeFormRegProb / homeAvgOdds;
				float awayFormOdds = neutralAwayFormRegProb / awayAvgOdds;
				float formOddsDiff = (homeFormOdds - awayFormOdds);
				float minFormOdds = Math.min(homeFormOdds, awayFormOdds);
				float maxFormOdds = Math.max(homeFormOdds, awayFormOdds);
				float minAvgOdds = Math.min(homeAvgOdds, awayAvgOdds);
				float maxAvgOdds = Math.max(homeAvgOdds, awayAvgOdds);
				float minRank = Math.min(rank1, rank2);
				int rankDiff = (rank1 - rank2);
				
				
				if((Float.compare(rankDiff, (int) 0) < 0) && (Float.compare(formOddsDiff, (float) 0) < 0) )
					continue;
				
				if((Float.compare(rankDiff, (int) 0) > 0) && (Float.compare(formOddsDiff, (float) 0) > 0) )
					continue;
				
//				if((Float.compare(minRegForm, (float) 0.9) < 0) && (Float.compare(maxRegForm, (float) 2.1) >= 0))
//					exception = 1;
//				
//				if((Float.compare(formOddsDiff, (float) 2.1) >= 0) || (Float.compare(formOddsDiff, (float) -2.1) <= 0))
//					exception = 1;
				

				if( (Float.compare(minRegForm, (float) 0.9) >= 0))
					continue;
				
				if((Float.compare(maxRegForm, (float) 2.1) < 0))
					continue;
		
				if ((Float.compare(formOddsDiff, (float) 1.5) < 0) &&  (Float.compare(formOddsDiff, (float) -1.5) > 0) )
					continue;	
				
				if((Float.compare(minRank, (int) 1000) > 0))
					continue;

				
					if (true) {
						
						myWriter.write(date);
						myWriter.write(",");

					myWriter.write(homeName + " (" + rank1 + ") " + "- " + homeAvgOdds + " / " + neutralHomeFormRegProb);
					myWriter.write(",");
					myWriter.write(awayName  + " (" + rank2 + ") " + "- " +awayAvgOdds + " / " + neutralAwayFormRegProb);
					myWriter.write(",");
						myWriter.write(Double.toString(formOddsDiff));
						myWriter.write(",");
						myWriter.write(link);
						myWriter.write(",");
						myWriter.write("links.add(\"" + link + "\"&timezone=-7);");

						myWriter.write(System.lineSeparator()); // new line

						System.out.println(link);
						System.out.format("|%-25s|", date);
						System.out.format("|%-25s|", matchScore);
						System.out.println();

						System.out.format("|%-25s|", "Players");
						System.out.format("|%-25s|", homeName + " (" + rank1 + ")");
						System.out.format("|%-25s|", awayName + " (" + rank2 + ")");;
						System.out.format("|%-25s|", "");
						System.out.println();
						System.out.format("|%-25s|", "Form");
						System.out.format("|%-25s|", neutralHomeFormRegProb);
						System.out.format("|%-25s|", neutralAwayFormRegProb);
						System.out.format("|%-25s|", "");
						System.out.println();
						System.out.format("|%-25s|", "Odds");
						System.out.format("|%-25s|", homeAvgOdds);
						System.out.format("|%-25s|", awayAvgOdds);
						System.out.format("|%-25s|", formOddsDiff);
						System.out.println();
						System.out.format("|%-25s|", "betType -> " + betType);
						System.out.println();

					} else
						continue;

			} catch (Exception e) {
				// System.out.println(e);

			}

			continue;
			// end link while
		}

		// closing the browser
		myWriter.close();

		driver.close();
		driver.quit();

		// end main
	}

	public float avg(float one, float two) {

		return (one + two) / 2;
	}
	// end class
}
