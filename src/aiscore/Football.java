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

		WebDriverWait wait = new WebDriverWait(driver, 10000);
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

		String day = "28", month = "11", year = "2022";

		Football ls = new Football();
		String mode = "";
		// links = ls.scheduleGrab(driver,i,h,links, 1147,2);
		links = ls.fixtureGrab(driver, i, h, links, wait, 1, 1500, day, month, year);
		// wait.until(ExpectedConditions.visibilityOfElementLocated0By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[500]")));

		System.out.println(day + "," + month + "," + year);

//		links.add("https://m.aiscore.com/match-fk-cukaricki-mladost-novi-sad/xvkjoizgmpvc879/h2h");

		// Using list iterator
		ListIterator<String> litr = null;
		litr = links.listIterator();

		while (litr.hasNext()) {

			String link = litr.next();
			System.out.println(link);
			driver.get(link);
			System.out.println("link # (" + linknum + " / " + links.size() + ")");
			linknum++;

			float homeForm = 0, awayForm = 0;

			String homeName, awayName, date, matchScore = "", halfScore = "", league = "";

			float homeWins, homeDraws, homeLosses, awayWins, awayDraws, awayLosses, homeScored, homeConceded,
					awayScored, awayConceded, totalScored, homeOdds = 0, awayOdds = 0;

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

				if (league.contains("U17") || league.contains("U18") || league.contains("Division 3")
						|| league.contains("4th Division") || league.contains("Hong Kong")
						|| league.contains("Gamma Ethniki") || league.contains("Frauen Bundesliga")
						|| league.contains("Women's Premier League") || league.contains("Women's Serie A")

						|| league.contains("South Africa Women's League")
						|| league.contains("Guatemala Women's Liga Nacional") || league.contains("Russia"))
					continue;

				// get matchTitle
				date = driver
						.findElement(By.xpath(
								"//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[1]/div/header/div/div[2]/span/span/span[2]"))
						.getText();

//				driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]/div[2]")).click();

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

				homeWins = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])[" + (1 + elsize) + "]")).getText());

				homeDraws = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='d'])[" + (1 + elsize) + "]")).getText());

				homeLosses = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])[" + (1 + elsize) + "]")).getText());

				homeScored = Float.parseFloat(
						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (1 + mybluesize) + "]")).getText());

				homeConceded = Float.parseFloat(
						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (2 + mybluesize) + "]")).getText());

				awayWins = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])[" + (2 + elsize) + "]")).getText());

				awayDraws = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='d'])[" + (2 + elsize) + "]")).getText());

				awayLosses = Float
						.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])[" + (2 + elsize) + "]")).getText());

				awayScored = Float.parseFloat(
						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (3 + mybluesize) + "]")).getText());

				awayConceded = Float.parseFloat(
						driver.findElement(By.xpath("(//*[@class='myblue'])[" + (4 + mybluesize) + "]")).getText());

//				System.out.println("awayWins = " + awayWins);
//				System.out.println("awayLosses = " + awayLosses);

				homeForm = ((homeWins * 3) + (homeDraws)) / (homeWins + homeDraws + homeLosses);

				awayForm = ((awayWins * 3) + (awayDraws)) / (awayWins + awayDraws + awayLosses);

				// odds

				String link2 = link;

				try {

					link = link.substring(0, link.length() - 4);
					link = link + "/odds";
					driver.get(link);

				} catch (Exception e) {
				}

//				wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div[1]/div/span"))));
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
//
//
//				if((Float.compare(minOdds, (float) 1) < 0) )
//					continue;

//				System.out.println("neutralHomeFormRegProb = " + neutralHomeFormRegProb);
//				System.out.println("neutralAwayFormRegProb = " + neutralAwayFormRegProb);

				homeScored = (homeScored + awayConceded) / 2;
				awayScored = (awayScored + homeConceded) / 2;
				totalScored = homeScored + awayScored;

				float maxScored = Math.max(homeScored, awayScored);

				float minRegForm = Math.min(homeForm, awayForm);
				float maxRegForm = Math.max(homeForm, awayForm);
				float formDiff = (homeForm - awayForm);

				int exception = 0;
				String betType = "";
				double oddsBetThis = 0.0;

//				if((Float.compare(minOdds, (float) 1.3) < 0))
//					exception = 1;

				if ((Float.compare(totalScored, (float) 2.7) >= 0))
					oddsBetThis = 0.5;
				if ((Float.compare(totalScored, (float) 3.2) >= 0))
					oddsBetThis = 1.5;
				if ((Float.compare(totalScored, (float) 4.1) >= 0))
					oddsBetThis = 2.5;
				if ((Float.compare(totalScored, (float) 5.0) >= 0))
					oddsBetThis = 3.5;

				if ((Float.compare(homeScored, (float) 2.5) >= 0) && oddsBetThis < 1)
					oddsBetThis++;
				if ((Float.compare(awayScored, (float) 2.5) >= 0) && oddsBetThis < 1)
					oddsBetThis++;
				if ((Float.compare(homeScored, (float) 3.5) >= 0) && oddsBetThis < 2)
					oddsBetThis++;
				if ((Float.compare(awayScored, (float) 3.5) >= 0) && oddsBetThis < 2)
					oddsBetThis++;

				if ((Float.compare(minRegForm, 1) >= 0) || (Float.compare(maxRegForm, 2) < 0))
					betType = "NO SIDES";
				else
					betType = "PREBET SIDES";

//				if(oddsBetThis < 0)
//				continue;

				if ((Float.compare(maxRegForm, (float) 1.8) < 0)
						|| ((Float.compare(formDiff, (float) 1.1) < 0) && (Float.compare(formDiff, (float) -1.1) > 0))
						|| (homeWins + homeLosses < 10))
					continue;

				if (awayWins + awayLosses < 10)
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
					myWriter.write(link2);
					myWriter.write(",");
					myWriter.write("links.add(\"" + link2 + "\");");

					myWriter.write(System.lineSeparator()); // new line

					System.out.println(link2);
					System.out.println(date);
					System.out.println(league);

					System.out.format("|%-25s|", homeName + " - " + homeScore + " (" + homeHalfScore + ")");
					System.out.format("|%-25s|", awayName + " - " + awayScore + " (" + awayHalfScore + ")");
					System.out.println();
					System.out.format("|%-25s|", Float.toString(homeForm).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(awayForm).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(formDiff).substring(0, 4));
					System.out.println();
//						System.out.format("|%-25s|", Float.toString(homeFormOdds).substring(0, 3));
//						System.out.format("|%-25s|", Float.toString(awayFormOdds).substring(0, 3));
//						System.out.format("|%-25s|", Float.toString(formOddsDiff).substring(0, 3));
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
