package aiscore;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Basketball {

	public ArrayList<String> fixtureGrab(WebDriver driver, int i, int h, ArrayList<String> links, WebDriverWait wait,
			int startIndex, int endIndex, String day, String month, String year) {

		driver.get("https://m.aiscore.com/basketball/"+year+""+month+""+day+"");

		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app\"]/div[2]/div/div[4]"))));
		
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[4]")).click();

		i = startIndex;
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		
		while (true && i < endIndex) {
			try {

				h =  i;



				WebElement element = driver.findElement(By.xpath("(//*[@itemscope])["+(h)+"]/a"));
				
				je.executeScript("arguments[0].scrollIntoView(true);",element);
				
				//je.executeScript("window.scrollBy(0,500)", "");


				String fixture = driver.findElement(By.xpath("(//*[@itemscope])["+h+"]/a")).getAttribute("href");
				
//				System.out.println("fixture = " + fixture);
//				System.out.println("fixture l= " + fixture.substring(fixture.length()-4, fixture.length()));

				if(!fixture.substring(fixture.length()-4, fixture.length()).equals("/h2h"))
					fixture = fixture + "/h2h";
				
				links.add(fixture);
				
				//String[] fixtureSplit = fixture.split("_");
				//links.add("https://www.goaloo.mobi/basketball/match/h2h-" + fixtureSplit[1]);

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
		options.addArguments("--window-size=2560,144000");

//        options.addArguments("--user-data-dir=C:/Users/PAC/Desktop/p1"); // Bypass OS security model
//
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);

		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date1 = new Date(System.currentTimeMillis());
		System.out.println(formatter1.format(date1));
		File file = new File("./bbBets/bbBets_" + formatter1.format(date1) + ".csv");

		// Create the file
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}

		Writer myWriter = new FileWriter(file);

		ArrayList<String> links = new ArrayList<String>();
		int i = 1;
		int h = 0;
		int linknum = 1;

		String day = "18", month = "12", year = "2022";
		
		Basketball ls = new Basketball();
		String mode = "";
		// links = ls.scheduleGrab(driver,i,h,links, 1147,2);
		links = ls.fixtureGrab(driver, i, h, links, wait, 1, 1000, day,month,year);
		// wait.until(ExpectedConditions.visibilityOfElementLocated0By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[500]")));

		System.out.println(day + "," + month + "," + year);

//		links.add("https://m.aiscore.com/basketball/match-bakkei-bornova-beledtyesi/wv784sxdooxsoqr/h2h");

		
		
		// Using list iterator
		ListIterator<String> litr = null;
		litr = links.listIterator();

		while (litr.hasNext()) {

			String link = litr.next();
			System.out.println(link);
			driver.get(link);
			System.out.println("link # (" + linknum + " / " + links.size() + ")");
			linknum++;



			float neutralHomeFormRegProb = 0, neutralAwayFormRegProb = 0;

			String homeName, awayName, date,matchScore = "";
			
			float homeWins, homeLosses, awayWins, awayLosses;


		
			try {


				matchScore = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[1]")).getText();

				

			} catch (Exception e) {
				matchScore = "";

			}


			try {
				// get time of game

				// get home name
				homeName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/a[1]/div[2]")).getText();
				// System.out.println("homeName = " + homeName );

				// get away name
				awayName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/a[2]/div[2]")).getText();
				// System.out.println("awayName = " + awayName );

				// get matchTitle
				date = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div/header/div/div[2]/span")).getText();


				List<WebElement> els = new ArrayList<WebElement>();
				
				els = driver.findElements(By.xpath("(//*[@class='w'])"));
				
				//System.out.println(els.size());
				
				
				int elsize = 0;
				
				if(els.size() == 3)
					elsize = 1;
				
				List<WebElement> mores = new ArrayList<WebElement>();
				
				mores = driver.findElements(By.xpath("(//*[@class='more'])"));
				
				//System.out.println(mores.size());
				
				
				int moresize = 0;
				
				if(mores.size() == 3)
					moresize = 1;
				
				
				try {
					// wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("(//*[@class='more'])["+(1+elsize)+"]")));
					driver.findElement(By.xpath("(//*[@class='more'])["+(1+moresize)+"]")).click();

				}catch(Exception e)
				{}
				
				try {
					
					driver.findElement(By.xpath("(//*[@class='more'])["+(2+moresize)+"]")).click();
					

				}catch(Exception e)
				{}
				
				try {
					// wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("(//*[@class='more'])["+(1+elsize)+"]")));
					driver.findElement(By.xpath("(//*[@class='more'])["+(1+moresize)+"]")).click();
		
				}catch(Exception e)
				{}
				
				try {
					
					driver.findElement(By.xpath("(//*[@class='more'])["+(2+moresize)+"]")).click();
	
					
				}catch(Exception e)
				{}
				
				try {
					// wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("(//*[@class='more'])["+(1+elsize)+"]")));
					driver.findElement(By.xpath("(//*[@class='more'])["+(1+moresize)+"]")).click();

					
				}catch(Exception e)
				{}
				
				try {
					
					driver.findElement(By.xpath("(//*[@class='more'])["+(2+moresize)+"]")).click();

					
				}catch(Exception e)
				{}
				

				
				
				homeWins = Float.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])["+(1+elsize)+"]")).getText());

				homeLosses = Float.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])["+(1+elsize)+"]")).getText());

//				System.out.println("homeWins = " + homeWins);
//				System.out.println("homeLosses = " + homeLosses);

				
				awayWins = Float.parseFloat(driver.findElement(By.xpath("(//*[@class='w'])["+(2+elsize)+"]")).getText());

				awayLosses = Float.parseFloat(driver.findElement(By.xpath("(//*[@class='l'])["+(2+elsize)+"]")).getText());

//				System.out.println("awayWins = " + awayWins);
//				System.out.println("awayLosses = " + awayLosses);
				
				neutralHomeFormRegProb = (homeWins * 3) / (homeWins + homeLosses);

				neutralAwayFormRegProb = (awayWins * 3) / (awayWins + awayLosses);

//				System.out.println("neutralHomeFormRegProb = " + neutralHomeFormRegProb);
//				System.out.println("neutralAwayFormRegProb = " + neutralAwayFormRegProb);

				float minRegForm = Math.min(neutralHomeFormRegProb, neutralAwayFormRegProb);
				float maxRegForm = Math.max(neutralHomeFormRegProb, neutralAwayFormRegProb);
				float formDiff = neutralHomeFormRegProb - neutralAwayFormRegProb;


				
				if( ( (Float.compare(minRegForm, (float) 0.5) >= 0) || (Float.compare(maxRegForm, (float) 2.1) < 0) ))
					continue;

				
//				if (homeName.contains("Women") || homeName.contains("Woman") || homeName.contains("woman")
//						|| homeName.contains("women") || homeName.contains(" w") || homeName.contains(" W ")
//						|| homeName.contains("(w)") || homeName.contains("(W)") || homeName.contains("Ladies")
//						|| homeName.contains("ladies") || date.contains("B2 League"))
//					continue;

		
				if(homeWins+homeLosses < 10)
					continue;
				
				if(awayWins+awayLosses < 10)
					continue;
				
				
				
				

				
					if (true) {
						myWriter.write(date);
						myWriter.write(",");
						myWriter.write(homeName + " - "+ neutralHomeFormRegProb);
						myWriter.write(",");
						myWriter.write(awayName + " - " + neutralAwayFormRegProb);

						myWriter.write(",");
						myWriter.write(link);
						myWriter.write(",");
						myWriter.write("links.add(\"" + link + "\");");

						myWriter.write(System.lineSeparator()); // new line

						System.out.println(link);
						System.out.println(date );
						System.out.println(matchScore );
						System.out.format("|%-25s|", homeName);
						System.out.format("|%-25s|", awayName);
						System.out.format("|%-25s|", "");
						System.out.println();
						System.out.format("|%-25s|", neutralHomeFormRegProb);
						System.out.format("|%-25s|", neutralAwayFormRegProb);
						System.out.format("|%-25s|", "");
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
