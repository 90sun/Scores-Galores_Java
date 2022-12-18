package aiscore;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Football {

	public ArrayList<String> fixtureGrab(WebDriver driver, int i, int h, ArrayList<String> links, WebDriverWait wait,
			int startIndex, int endIndex, String day, String month, String year) {

		driver.get("https://m.aiscore.com/" + year + "" + month + "" + day + "");
//		driver.get("https://m.aiscore.com/tournament-chinese-super-league/2j374oi24h4qo6d/matches");

		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app\"]/div[2]/div/div[4]"))));

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[4]")).click();

		i = startIndex;

		JavascriptExecutor je = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("(//*[@class='list']/div/a)[1]"))));

		while (true && i < endIndex) {
			try {

				h = i;

				WebElement element = driver.findElement(By.xpath("(//*[@class='list']/div/a)[" + (h) + "]"));

				je.executeScript("arguments[0].scrollIntoView(true);", element);

				// je.executeScript("window.scrollBy(0,500)", "");

				String fixture = driver.findElement(By.xpath("(//*[@class='list']/div/a)[" + (h) + "]"))
						.getAttribute("href");

//				System.out.println("fixture = " + fixture);
//				System.out.println("fixture l= " + fixture.substring(fixture.length()-4, fixture.length()));

				if (!fixture.substring(fixture.length() - 4, fixture.length()).equals("/h2h"))
					fixture = fixture + "/h2h";

				links.add(fixture);

				// String[] fixtureSplit = fixture.split("_");
				// links.add("https://www.goaloo.mobi/basketball/match/h2h-" + fixtureSplit[1]);

				i++;

			} catch (Exception e) {
				// System.out.println(e);

				System.out.println("# links = " + links.size());
				break;
			}

		}

		return links;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// setting the driver executable
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox"); // Bypass OS security model
		options.addArguments("headless"); // Bypass OS security model
		options.addArguments("--disable-extensions"); // Bypass OS security model
		options.addArguments("--window-size=2560,300000");

//        options.addArguments("--user-data-dir=C:/Users/PAC/Desktop/p1"); // Bypass OS security model
//
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);

		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date1 = new Date(System.currentTimeMillis());
		System.out.println(formatter1.format(date1));
		File file = new File("./footyBets/footyBets_" + formatter1.format(date1) + ".csv");

		// Create the file
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}

		Writer myWriter = new FileWriter(file);

		ArrayList<String> links = new ArrayList<>();
		int i = 1;
		int h = 0;
		int linknum = 1;

		String day = "1", month = "12", year = "2022";

		Football ls = new Football();
		String mode = "";
		// links = ls.scheduleGrab(driver,i,h,links, 1147,2);
		links = ls.fixtureGrab(driver, i, h, links, wait, 1, 1500, day, month, year);
		// wait.until(ExpectedConditions.visibilityOfElementLocated0By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[500]")));

		System.out.println(day + "," + month + "," + year);

//		links.add("https://m.aiscore.com/match-shandong-taishan-shenzhen-fc/oj7x9iz0z8eb47g/h2h\r\n"
//				+ "");
//		links.add("https://m.aiscore.com/match-larne-fc-dungannon-swifts/jr7owi3n3p6tgq0/h2h");

		// Using list iterator
		ListIterator<String> litr = null;
		litr = links.listIterator();

		while (litr.hasNext()) {

			String link = litr.next();
			System.out.println(link);
			driver.get(link);
			System.out.println("link # (" + linknum + " / " + links.size() + ")");
			linknum++;

			float l6homeForm = 0, l6awayForm = 0 ,l12homeForm = 0, l12awayForm = 0 ,l18homeForm = 0, l18awayForm = 0, homeForm = 0, awayForm = 0, homeScored = 0, awayScored = 0, homeConceded = 0, awayConceded = 0 , totalScored;

			String homeName, awayName, date, matchScore = "", halfScore = "", league = "", status = "";

			float l6homeWins, l6homeDraws, l6homeLosses, l6awayWins, l6awayDraws, l6awayLosses, l6totalScored, l6homeScored = 0, l6awayScored = 0, l6homeConceded = 0, l6awayConceded = 0,
					l12homeWins, l12homeDraws, l12homeLosses, l12awayWins, l12awayDraws, l12awayLosses, l12homeScored, l12homeConceded,
					l12awayScored, l12awayConceded, l12totalScored,
					l18homeWins, l18homeDraws, l18homeLosses, l18awayWins, l18awayDraws, l18awayLosses, l18homeScored, l18homeConceded,
					l18awayScored, l18awayConceded, l18totalScored,homeOdds = 0, awayOdds = 0;

			int homeScore = 0;
			int awayScore = 0;
			int homeHalfScore = 0;
			int awayHalfScore = 0;

			try {

				matchScore = driver
						.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[1]"))
						.getText();

				String[] msSplit = matchScore.split(" - ");

//				System.out.println("msSplit 0 = " + msSplit[0]);
//				System.out.println("msSplit 0 = " + msSplit[1]);

				homeScore = Integer.parseInt(msSplit[0]);
				awayScore = Integer.parseInt(msSplit[1]);

				halfScore = driver
						.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[2]"))
						.getText();

				String[] hsSplit = halfScore.split(":");

//				System.out.println("hsSplit 0 = " + hsSplit[0].substring(3,hsSplit[0].length()));
//				System.out.println("hsSplit 0 = " + hsSplit[1]);

				homeHalfScore = Integer.parseInt(hsSplit[0].substring(3, hsSplit[0].length()));
				awayHalfScore = Integer.parseInt(hsSplit[1]);

			} catch (Exception e) {
				matchScore = "";
				halfScore = "";

			}

			try {
				// get time of game

				// get home name
				homeName = driver
						.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/div[2]"))
						.getText();
				// System.out.println("homeName = " + homeName );

				// get away name
				awayName = driver
						.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]/div[2]"))
						.getText();
				// System.out.println("awayName = " + awayName );

				league = driver
						.findElement(By.xpath(
								"//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[1]/div/header/div/div[2]/span/span/span[1]"))
						.getText();

				if (homeName.contains("U17")  || awayName.contains("U18")|| homeName.contains("Odder") || homeName.contains("Feyenoord")|| homeName.contains("Stevenage Borough") || homeName.contains("Veszprem")  || homeName.contains("NK Aluminij")  || homeName.contains("Koln U19") || homeName.contains("Notts County")|| homeName.contains("La Union CF") || league.contains("English FA Women's Super League") || league.contains("Guatemala Women's Liga Nacional")|| league.contains("Hong Kong")|| league.contains("Frauen Bundesliga") || homeName.contains("Ethnikos Pireaus") || homeName.contains("Kocaelispor")|| league.contains("Sweden Damallsvenskan") 
 )	
					continue;

				// get matchTitle
				date = driver
						.findElement(By.xpath(
								"//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[1]/div/header/div/div[2]/span/span/span[2]"))
						.getText();

//				driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]/div[2]")).click();
				
				// get matchStatus
				status = driver
						.findElement(By.xpath(
								"//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div[1]/div/span"))
						.getText();
				
				System.out.println("Status = " + status);
				
				if(status.contains("Postponed") || status.contains("TBD") || status.contains("Canceled") )
					continue;

				List<WebElement> els = new ArrayList<>();

				els = driver.findElements(By.xpath("(//*[@class='w'])"));

				// System.out.println(els.size());

				int elsize = 0;
				int mybluesize = 0;

				if (els.size() == 3) {
					elsize = 1;
					mybluesize = 2;

				}

				List<WebElement> mores = new ArrayList<>();

				mores = driver.findElements(By.xpath("(//*[@class='more'])"));

				// System.out.println(mores.size());

				int moresize = 0;

				if (mores.size() == 3)
					moresize = 1;

				try {
					// wait.until(ExpectedConditions.presenceOfElementLocated
					// (By.xpath("(//*[@class='more'])["+(1+elsize)+"]")));
					driver.findElement(By.xpath("(//*[@class='more'])[" + (1 + moresize) + "]")).click();

				} catch (Exception e) {
				}

				try {

					driver.findElement(By.xpath("(//*[@class='more'])[" + (2 + moresize) + "]")).click();

				} catch (Exception e) {
				}



//				l6homeWins = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])[" + (1 + elsize) + "]")).getText());
//
//				l6homeDraws = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='d'])[" + (1 + elsize) + "]")).getText());
//
//				l6homeLosses = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])[" + (1 + elsize) + "]")).getText());
//
//				l6homeScored = Float.parseFloat(
//						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (1 + mybluesize) + "]")).getText());
//
//				l6homeConceded = Float.parseFloat(
//						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (2 + mybluesize) + "]")).getText());
//
//				l6awayWins = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])[" + (2 + elsize) + "]")).getText());
//
//				l6awayDraws = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='d'])[" + (2 + elsize) + "]")).getText());
//
//				l6awayLosses = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])[" + (2 + elsize) + "]")).getText());
//
//				l6awayScored = Float.parseFloat(
//						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (3 + mybluesize) + "]")).getText());
//
//				l6awayConceded = Float.parseFloat(
//						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (4 + mybluesize) + "]")).getText());
//
////				System.out.println("l12awayDraws = " + l12awayWins);
////				System.out.println("l12awayLosses = " + l12awayLosses);
//
//				l6homeForm = ((l6homeWins * 3) + (l6homeDraws)) / (l6homeWins + l6homeDraws + l6homeLosses);
//
//				l6awayForm = ((l6awayWins * 3) + (l6awayDraws)) / (l6awayWins + l6awayDraws + l6awayLosses);
				
				try {
					// wait.until(ExpectedConditions.presenceOfElementLocated
					// (By.xpath("(//*[@class='more'])["+(1+elsize)+"]")));
					driver.findElement(By.xpath("(//*[@class='more'])[" + (1 + moresize) + "]")).click();

				} catch (Exception e) {
				}

				try {

					driver.findElement(By.xpath("(//*[@class='more'])[" + (2 + moresize) + "]")).click();

				} catch (Exception e) {
				}



//				l12homeWins = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])[" + (1 + elsize) + "]")).getText());
//
//				l12homeDraws = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='d'])[" + (1 + elsize) + "]")).getText());
//
//				l12homeLosses = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])[" + (1 + elsize) + "]")).getText());
//
//				l12homeScored = Float.parseFloat(
//						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (1 + mybluesize) + "]")).getText());
//
//				l12homeConceded = Float.parseFloat(
//						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (2 + mybluesize) + "]")).getText());
//
//				l12awayWins = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])[" + (2 + elsize) + "]")).getText());
//
//				l12awayDraws = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='d'])[" + (2 + elsize) + "]")).getText());
//
//				l12awayLosses = Float
//						.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])[" + (2 + elsize) + "]")).getText());
//
//				l12awayScored = Float.parseFloat(
//						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (3 + mybluesize) + "]")).getText());
//
//				l12awayConceded = Float.parseFloat(
//						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (4 + mybluesize) + "]")).getText());
//
////				System.out.println("awayWins = " + awayWins);
////				System.out.println("awayLosses = " + awayLosses);
//
//				l12homeForm = ((l12homeWins * 3) + (l12homeDraws)) / (l12homeWins + l12homeDraws + l12homeLosses);
//
//				l12awayForm = ((l12awayWins * 3) + (l12awayDraws)) / (l12awayWins + l12awayDraws + l12awayLosses);
				
				try {
					// wait.until(ExpectedConditions.presenceOfElementLocated
					// (By.xpath("(//*[@class='more'])["+(1+elsize)+"]")));
					driver.findElement(By.xpath("(//*[@class='more'])[" + (1 + moresize) + "]")).click();

				} catch (Exception e) {
				}

				try {

					driver.findElement(By.xpath("(//*[@class='more'])[" + (2 + moresize) + "]")).click();

				} catch (Exception e) {
				}



				l18homeWins = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])[" + (1 + elsize) + "]")).getText());

				l18homeDraws = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='d'])[" + (1 + elsize) + "]")).getText());

				l18homeLosses = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])[" + (1 + elsize) + "]")).getText());

				l18homeScored = Float.parseFloat(
						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (1 + mybluesize) + "]")).getText());

				l18homeConceded = Float.parseFloat(
						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (2 + mybluesize) + "]")).getText());

				l18awayWins = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])[" + (2 + elsize) + "]")).getText());

				l18awayDraws = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='d'])[" + (2 + elsize) + "]")).getText());

				l18awayLosses = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])[" + (2 + elsize) + "]")).getText());

				l18awayScored = Float.parseFloat(
						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (3 + mybluesize) + "]")).getText());

				l18awayConceded = Float.parseFloat(
						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (4 + mybluesize) + "]")).getText());

//				System.out.println("awayWins = " + awayWins);
//				System.out.println("awayLosses = " + awayLosses);

				l18homeForm = ((l18homeWins * 3) + (l18homeDraws)) / (l18homeWins + l18homeDraws + l18homeLosses);

				l18awayForm = ((l18awayWins * 3) + (l18awayDraws)) / (l18awayWins + l18awayDraws + l18awayLosses);

				homeForm = l18homeForm;
				awayForm = l18awayForm;
				homeScored = l18homeScored;
				awayScored = l18awayScored;
				homeConceded = l18homeConceded;
				awayConceded = l18awayConceded;
				// odds
//				String link2 = link;

//				try {
//
//					link = link.substring(0, link.length() - 4);
//					link = link + "/odds";
//					driver.get(link);
//
//				} catch (Exception e) {
//				}

//				wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div[1]/div/span"))));
//
//
//				try {
//				homeOdds = Float.parseFloat(driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div[1]/div/span")).getText());
//				}catch(Exception e) {}
//				try {
//				awayOdds = Float.parseFloat(driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div[3]/div/span")).getText());
//				}catch(Exception e) {}
//
//				float minOdds = Math.min(homeOdds, awayOdds);
//				float homeFormOdds = homeForm / homeOdds;
//				float awayFormOdds = awayForm / awayOdds;
//
//				float formOddsDiff = homeFormOdds - awayFormOdds;


				
//				if((Float.compare(minOdds, (float) 1.0) < 0) )
//					continue;
//				System.out.println("neutralHomeFormRegProb = " + neutralHomeFormRegProb);
//				System.out.println("neutralAwayFormRegProb = " + neutralAwayFormRegProb);

				homeScored = (homeScored + awayConceded) / 2;
				awayScored = (awayScored + homeConceded) / 2;
				totalScored = homeScored + awayScored;

				float maxScored = Math.max(homeScored, awayScored);

				float minForm = Math.min(homeForm, awayForm);
				float maxForm = Math.max(homeForm, awayForm);
				float formDiff = (homeForm - awayForm);

				int exception = 0;
				String betType = "";
				double oddsBetThis = -0.5;

				if ((Float.compare(homeScored, (float) 1.6) >= 0))
					oddsBetThis++;
				if ((Float.compare(awayScored, (float) 1.6) >= 0))
					oddsBetThis++;
				if ((Float.compare(homeScored, (float) 2.6) >= 0))
					oddsBetThis++;
				if ((Float.compare(awayScored, (float) 2.6) >= 0))
					oddsBetThis++;
				if ((Float.compare(homeScored, (float) 3.6) >= 0))
					oddsBetThis++;
				if ((Float.compare(awayScored, (float) 3.6) >= 0))
					oddsBetThis++;
				if ((Float.compare(homeScored, (float) 4.6) >= 0))
					oddsBetThis++;
				if ((Float.compare(awayScored, (float) 4.6) >= 0))
					oddsBetThis++;
				
				if(oddsBetThis < 0)
					continue;
				
				if((Float.compare(formDiff, (float) 0) > 0) && ( (Float.compare(maxForm, (float) 1.9) < 0) || (Float.compare(formDiff, (float) 1) < 0) ) )
					continue;
				

				if((Float.compare(formDiff, (float) 0) < 0) && ((Float.compare(maxForm, (float) 1.9) < 0)  || (Float.compare(formDiff, (float) 1.6) < 0) ) )
					continue;
				

				if((Float.compare(formDiff, (float) 0) > 0) && (Float.compare(minForm, (float) 0.9) >= 0)  )
				{
					betType = "MAX NO SIDES";
				}
				
				if((Float.compare(formDiff, (float) 0) < 0) && (Float.compare(minForm, (float) 0.7) >= 0)  )
				{
					betType = "MAX NO SIDES";
				}

				if((Float.compare(formDiff, (float) 0.1) < 0) && (Float.compare(formDiff, (float) -0.1) > 0))
					continue;
				
				if(betType.equals("") || (Float.compare(formDiff, (float) 1.5) >= 0) )
					oddsBetThis++;

				
				if((l18homeWins + l18homeDraws + l18homeLosses) < 18)
					continue;
				if((l18awayWins + l18awayDraws + l18awayLosses) < 18)
					continue;
								
				if (true) {
					myWriter.write(date);
					myWriter.write(",");
					myWriter.write(homeName + " - " + Float.toString(homeForm).substring(0, 3) + " - "
							+ Float.toString(homeScored).substring(0, 3));
					myWriter.write(",");
					myWriter.write(awayName + " - " + Float.toString(awayForm).substring(0, 3) + " - "
							+ Float.toString(awayScored).substring(0, 3));
					myWriter.write(",");
					myWriter.write(Double.toString(oddsBetThis));
					myWriter.write(",");
					myWriter.write(betType);
					myWriter.write(",");
					myWriter.write(league);
					myWriter.write(",");
//					myWriter.write(link2);
//					myWriter.write(",");
//					myWriter.write("links.add(\"" + link2 + "\");");

					myWriter.write(System.lineSeparator()); // new line

					System.out.println(link);
					System.out.println(date);
					System.out.println(league);

					System.out.format("|%-25s|", homeName + " - " + homeScore + " (" + homeHalfScore + ")");
					System.out.format("|%-25s|", awayName + " - " + awayScore + " (" + awayHalfScore + ")");
					System.out.println();
					System.out.format("|%-25s|", Float.toString(homeForm).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(awayForm).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(formDiff).substring(0, 3));
					System.out.println();
//						System.out.format("|%-25s|", Float.toString(homeOdds).substring(0, 3));
//						System.out.format("|%-25s|", Float.toString(awayOdds).substring(0, 3));
//						System.out.format("|%-25s|", Float.toString(formOddsDiff).substring(0, 4));
//						System.out.println();
					System.out.format("|%-25s|", Float.toString(homeScored).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(awayScored).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(totalScored).substring(0, 3));
					System.out.println();
					System.out.format("|%-25s|", "oddsBetThis -> " + oddsBetThis);
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
