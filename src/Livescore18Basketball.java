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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Livescore18Basketball {

	public ArrayList<String> fixtureGrab(WebDriver driver, int i, int h, ArrayList<String> links, WebDriverWait wait,
			int startIndex, int endIndex, String day) {

		driver.get("https://www.goaloo.mobi/basketball/schedule-" + day + "");

		driver.findElement(By.xpath("//*[@id='fHead']/div[1]/span[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='displayZone']")));
		driver.findElement(By.xpath("//*[@id='displayZone']")).click();
		driver.findElement(By.xpath("//*[@id='setting_popSel']/ul/li[8]")).click();
		driver.navigate().refresh();

		i = startIndex;

		while (true && i < endIndex) {
			try {

				h = i + 1;
				String postponedCanceledFT;
				String league;
				postponedCanceledFT = driver.findElement(By.xpath("//*[@id='gameList']/div[" + h + "]/div[2]/i"))
						.getText();

				league = driver.findElement(By.xpath("//*[@id='gameList']/div[" + h + "]/div[1]/div/div[1]/span[2]"))
						.getText();
				// System.out.println(postponedCanceledFT);
				if (postponedCanceledFT.equals("Postp.") || postponedCanceledFT.equals("Canceled")) {
					i++;

					continue;
				} else if (false)
//							!league.contains("WNBA") &&
//							!league.equals("ACB") &&
//							!league.equals("Serie A") &&
//							!league.equals("LNB") &&
//							!league.equals("BJL") &&
//							!league.equals("KBL") &&
//							!league.equals("EURO") &&
//							!league.equals("ULEB") &&
//							!league.equals("NCAA") &&
//							!league.equals("NBA") ) 
				{
					i++;
					continue;
				}
				String fixture = driver.findElement(By.xpath("//*[@id='gameList']/div[" + h + "]")).getAttribute("id");
				String[] fixtureSplit = fixture.split("_");
				links.add("https://www.goaloo.mobi/basketball/match/h2h-" + fixtureSplit[1]);

				i++;

			} catch (Exception e) {
				// System.out.println(e);
				System.out.println("# links = " + links.size());
				break;
			}

		}

		return links;

	}

	public ArrayList<String> scheduleGrab(WebDriver driver, int i, int h, ArrayList<String> links, int schedule,
			int week) {

		driver.get("http://www.goaloo.mobi/basketball/database/schedule-" + schedule + "?round=" + week);

		while (true) {

			try {

				h = i + 1;

				String scheduleTb = driver.findElement(By.xpath("//*[@id='scheduleTb']/tbody/tr[" + h + "]"))
						.getAttribute("href");
				String[] scheduleSplit = scheduleTb.split("-");

//
//			    System.out.println("scheduleSplit[0] = " + scheduleSplit[0]);
//			    System.out.println("scheduleSplit[1] = " + scheduleSplit[1]);

				if (scheduleTb.equals(null))
					i++;
				else
					links.add("https://www.goaloo.mobi/basketball/match/h2h-" + scheduleSplit[1]);
				{
					i++;
				}

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
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
		ChromeOptions options = new ChromeOptions();

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

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

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ArrayList<String> links = new ArrayList<String>();
		int i = 1;
		int h = 0;
		int linknum = 1;

		Livescore18Basketball ls = new Livescore18Basketball();
		String mode = "";
		// links = ls.scheduleGrab(driver,i,h,links, 1147,2);
		links = ls.fixtureGrab(driver, i, h, links, wait, 1, 300, "n1");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[500]")));

//		links.add("");
//	links.add("https://www.goaloo.mobi/basketball/match/h2h-449483");
//		links.add("http://www.goaloo.mobi/basketball/match/h2h-389065");
//		links.add("http://www.goaloo.mobi/basketball/match/h2h-389030");
//		links.add("http://www.goaloo.mobi/basketball/match/h2h-389016");

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
			ArrayList<Integer> homeGoals = new ArrayList<Integer>(); 
			ArrayList<Integer> homeOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> awayGoals = new ArrayList<Integer>();
			ArrayList<Integer> awayOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> neutralHomeGoals = new ArrayList<Integer>();
			ArrayList<Integer> neutralAwayGoals = new ArrayList<Integer>();

			float minHomeExpectedRecProb = 0, minAwayExpectedRecProb = 0, minHomeScoredAGoalExpectedRecProb = 0,
					minAwayScoredAGoalExpectedRecProb = 0, homeExpectedRecProb = 0, awayExpectedRecProb = 0,
					homeMinConsistencyRecProb = 0, awayMinConsistencyRecProb = 0, homeMaxConsistencyRecProb = 0,
					awayMaxConsistencyRecProb = 0, homeFormRecProb = 0, awayFormRecProb = 0, homeOneRecProb = 0,
					homeTwoRecProb = 0, homeThreeRecProb = 0, homeFourRecProb = 0, awayOneRecProb = 0,
					awayTwoRecProb = 0, awayThreeRecProb = 0, awayFourRecProb = 0, neutralMaxForm = 0,
					neutralHomeOneRecProb = 0, neutralHomeTwoRecProb = 0, neutralHomeThreeRecProb = 0,
					neutralHomeFourRecProb = 0, neutralAwayOneRecProb = 0, neutralAwayTwoRecProb = 0,
					neutralAwayThreeRecProb = 0, neutralAwayFourRecProb = 0, neutralHomeFormRecProb = 0,
					neutralAwayFormRecProb = 0, neutralHomeExpectedRecProb = 0, neutralAwayExpectedRecProb = 0,
					neutralHomeScoredAGoalExpectedRecProb = 0, neutralAwayScoredAGoalExpectedRecProb = 0,
					neutralAwayScoredRecProb = 0, neutralAwayConcededRecProb = 0, neutralAwayMinConsistencyRecProb = 0,
					neutralAwayMaxConsistencyRecProb = 0, neutralHomeScoredRecProb = 0, neutralHomeConcededRecProb = 0,
					neutralHomeMinConsistencyRecProb = 0, neutralHomeMaxConsistencyRecProb = 0;

			String homeName, awayName, homeTeamName, date, time, matchResult, matchType, matchTitle, matchDay,
					matchScore = "";
			int homeGoalTemp, homeOppGoalTemp, awayGoalTemp, awayOppGoalTemp, homeTotal, awayTotal, homeScore = 0,
					awayScore = 0, matchTotalScore;
			LocalDate todayDate = null;
			int days = 0;

			String league2;
			int leagueGameHome = 0, leagueGameAway = 0;
			boolean leagueGame = false;

			try {

				//driver.findElement(By.xpath("//*[@id=\"match\"]/nav/div[2]/a")).click();



				homeScore = Integer.parseInt(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/div[1]")).getText());
				// System.out.println("homeScore = " + homeScore);

				awayScore = Integer.parseInt(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/div[2]")).getText());

				// System.out.println("awayScore = " + awayScore);

			} catch (Exception e) {
				matchScore = "";
				homeScore = 0;
				awayScore = 0;
			}

			matchTotalScore = homeScore + awayScore;

			try {
			// get time of game
			date = driver.findElement(By.xpath("//*[@id='liveMt']")).getText();

			String[] dateSplit = date.split(" ");
			date = dateSplit[0];
			time = dateSplit[1];
			// System.out.println(date.substring(0, 10));
			todayDate = LocalDate.parse(date.substring(0, 10), formatter2);

			// get home name
			homeName = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[2]/div[1]/span")).getText();
			// System.out.println("homeName = " + homeName );

			// get away name
			awayName = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[2]/div[3]/span")).getText();
			// System.out.println("awayName = " + awayName );

			if (mode.equals("H/A Same")) {

				driver.findElement(By.xpath("//*[@id=\"f3\"]/span/label")).click();

			}



				// get matchTitle
				league2 = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[1]/div[1]/a")).getText();

				//// ================== BLACKLIST ===========================================

//					driver.findElement(By.xpath("//*[@id=\"f6\"]/span/select")).click();
//					driver.findElement(By.xpath("//*[@id=\"f6\"]/span/select/option[1]")).click();

				driver.findElement(By.xpath("//*[@id='match']/nav/div[3]/a")).click();

				driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/a[3]")).click();

				// String over =
				// driver.findElement(By.xpath("//*[@id='oContent']/div[2]/div[2]/div[1]/div[1]/span")).getText();

				String over = driver.findElement(By.xpath("//*[@id=\"oContent\"]/table/tbody/tr[6]/td[3]")).getText();

				// System.out.println("over = " + over);

				float betThis = Float.parseFloat(over);
				float minBetThis = betThis - 7;
				float maxBetThis = betThis + 7;

				driver.get(link);

				for (int j = 0; j < 2; j++) {

					homeForm.clear();
					awayForm.clear();
					homeGoals.clear();
					homeOppGoals.clear();
					awayGoals.clear();
					awayOppGoals.clear();

					if (!neutral) {

						try {
							driver.findElement(By.xpath("//*[@id=\"f3\"]/span/label")).click();
						}
						catch(Exception e){}

						}

					try {
						driver.findElement(By.xpath("//*[@id=\"f3\"]/span/label")).click();
						driver.findElement(By.xpath("//*[@id=\"f3\"]/span/label")).click();
						driver.findElement(By.xpath("//*[@id=\"f3\"]/span/label")).click();
						driver.findElement(By.xpath("//*[@id=\"f3\"]/span/label")).click();

					} catch (Exception e) {
						// System.out.println("No boxes to click");

						// continue;
					}

					// get home avg
					i = 1;

					while (true) {
						try {

							// homeTeamName =
							// driver.findElement(By.xpath("(//*[@id='e3_1']/table[1]//tr[@style='display:
							// table-row;']/td[2]/a/span[1])["+i+"]")).getText();

							matchType = driver.findElement(By
									.xpath("(//*[@id='e3_1']/table[1]//tr[@style='display: table-row;']/td[1]/div/div)["
											+ i + "]"))
									.getText();

							matchDay = driver.findElement(By.xpath(
									"(//*[@id='e3_1']/table[1]//tr[@style='display: table-row;']/td[1]/div/span)[" + i
											+ "]"))
									.getText();
							// System.out.println("MatchDay = " + matchDay );

							LocalDate matchDate = LocalDate.parse(matchDay, formatter);

							Period period = Period.between(matchDate, todayDate);

							days = period.getDays() + (period.getMonths() * 30) + (period.getYears() * 365);
							// System.out.println("Days since last match = " + days );

							if (days < 40)
								leagueGameHome++;

							if (leagueGameHome < 1)
								break;

//							    if(days  > 180) {
//							    	i++;
//							    	continue;	
//							     }

							matchResult = driver.findElement(By.xpath(
									"(//*[@id='e3_1']/table[1]//tr[@style='display: table-row;']/td[4])[" + i + "]"))
									.getAttribute("data-cls");

							// System.out.println("home match result = " + matchResult);

							homeGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e3_1']/table[1]//tr[@style='display: table-row;']/td[4]/span[1])["
											+ i + "]"))
									.getText());

							// System.out.println("homeName = " + matchResult);
							homeOppGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e3_1']/table[1]//tr[@style='display: table-row;']/td[4]/span[2])["
											+ i + "]"))
									.getText());

							// System.out.println("home opp goals = " + homeOppGoalTemp);

//							 System.out.println("homegoal = " +
//							 driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS1+"]//li[@style='display: "+
//							 "list-item;']/div[2]/div[2]/span[1])["+i+"]")).getText());
//							 System.out.println("homeoppgoal = " +
//							 driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS1+"]//li[@style='display: "+
//							 "list-item;']/div[2]/div[2]/span[2])["+i+"]")).getText());
							//
//							

							if (matchResult.equals("o-winBGp")) {
								homeForm.add(3);
								if (homeGoalTemp > homeOppGoalTemp) {
									homeGoals.add(homeGoalTemp);
									homeOppGoals.add(homeOppGoalTemp);
								} else {
									homeGoals.add(homeOppGoalTemp);
									homeOppGoals.add(homeGoalTemp);
								}

							} else if (matchResult.equals("o-voidBGp")) {
								homeForm.add(1);
								homeGoals.add(homeGoalTemp);
								homeOppGoals.add(homeGoalTemp);

							} else if (matchResult.equals("o-lossBGp")) {
								homeForm.add(0);
								if (homeGoalTemp > homeOppGoalTemp) {
									homeGoals.add(homeOppGoalTemp);
									homeOppGoals.add(homeGoalTemp);
								} else {
									homeGoals.add(homeGoalTemp);
									homeOppGoals.add(homeOppGoalTemp);
								}
							}

//	 						 System.out.println("home form = " + homeForm.get(i-1));
//							 System.out.println("home goals = " + homeGoals.get(i-1));
//							 System.out.println("home opp goals = " + homeOppGoals.get(i-1));

							i++;

						} catch (Exception e) {
//							System.out.println("no more home goals");
							// System.out.println(e.getMessage());
							break;
						}
					}

					leagueGame = false;
					i = 1;
					while (true) {
						try {

							// homeTeamName =
							// driver.findElement(By.xpath("(//*[@id='e3_1']/table[2]//tr[@style='display:
							// table-row;']/td[2]/a/span[1])["+i+"]")).getText();

							matchType = driver.findElement(By
									.xpath("(//*[@id='e3_1']/table[2]//tr[@style='display: table-row;']/td[1]/div/div)["
											+ i + "]"))
									.getText();

							matchDay = driver.findElement(By.xpath(
									"(//*[@id='e3_1']/table[2]//tr[@style='display: table-row;']/td[1]/div/span)[" + i
											+ "]"))
									.getText();
							// System.out.println("MatchDay = " + matchDay );

							LocalDate matchDate = LocalDate.parse(matchDay, formatter);

							Period period = Period.between(matchDate, todayDate);

							days = period.getDays() + (period.getMonths() * 30) + (period.getYears() * 365);
							// System.out.println("Days since last match = " + days );

							if (days < 40)
								leagueGameAway++;

							if (leagueGameAway < 1)
								break;

//								    if(days  > 180) {
//								    	i++;
//								    	continue;	
//	
//								     }

							matchResult = driver.findElement(By.xpath(
									"(//*[@id='e3_1']/table[2]//tr[@style='display: table-row;']/td[4])[" + i + "]"))
									.getAttribute("data-cls");

							// System.out.println("away match result = " + matchResult);

							awayGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e3_1']/table[2]//tr[@style='display: table-row;']/td[4]/span[1])["
											+ i + "]"))
									.getText());

							// System.out.println("away goal = " + awayGoalTemp);

							awayOppGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e3_1']/table[2]//tr[@style='display: table-row;']/td[4]/span[2])["
											+ i + "]"))
									.getText());

							// System.out.println("away opp goal = " + awayOppGoalTemp);

//							 System.out.println("awaygoal = " +
//							 driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS2+"]//li[@style='display:"+
//							 "list-item;']/div[2]/div[2]/span[2])["+i+"]")).getText());
//							 System.out.println("awayoppgoal = " +
//							 driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS2+"]//li[@style='display:"+
//							 "list-item;']/div[2]/div[2]/span[1])["+i+"]")).getText());

							if (matchResult.equals("o-winBGp")) {
								awayForm.add(3);
								if (awayGoalTemp > awayOppGoalTemp) {
									awayGoals.add(awayGoalTemp);
									awayOppGoals.add(awayOppGoalTemp);
								} else {
									awayGoals.add(awayOppGoalTemp);
									awayOppGoals.add(awayGoalTemp);
								}

							} else if (matchResult.equals("o-voidBGp")) {
								awayForm.add(1);
								awayGoals.add(awayGoalTemp);
								awayOppGoals.add(awayGoalTemp);

							} else if (matchResult.equals("o-lossBGp")) {
								awayForm.add(0);
								if (awayGoalTemp > awayOppGoalTemp) {
									awayGoals.add(awayOppGoalTemp);
									awayOppGoals.add(awayGoalTemp);
								} else {
									awayGoals.add(awayGoalTemp);
									awayOppGoals.add(awayOppGoalTemp);
								}
							}

//							 System.out.println("away form = " + awayForm.get(i-1));
//							 System.out.println("away goals = " + awayGoals.get(i-1));
//							 System.out.println("away opp goals = " + awayOppGoals.get(i-1));

							i++;

						} catch (Exception e) {
//							System.out.println("no more away goals");
							// System.out.println(e.getMessage());
							break;
						}
					}

					ArrayList<Integer> homeScored = new ArrayList<Integer>();
					ArrayList<Integer> awayScored = new ArrayList<Integer>();

					ArrayList<Integer> homeConceded = new ArrayList<Integer>();
					ArrayList<Integer> awayConceded = new ArrayList<Integer>();

					ArrayList<Integer> minConsistency = new ArrayList<Integer>();
					ArrayList<Integer> maxConsistency = new ArrayList<Integer>();

					float homeScoredRecAvg = 0, homeScoredRegAvg = 0, awayScoredRecAvg = 0, awayScoredRegAvg = 0,
							homeConcededRecAvg = 0, homeConcededRegAvg = 0, awayConcededRecAvg = 0,
							awayConcededRegAvg = 0, homeFormRecAvg = 0, awayFormRecAvg = 0, homeFormRegAvg = 0,
							awayFormRegAvg = 0, minConsistencyRecAvg = 0, minConsistencyRegAvg = 0,
							maxConsistencyRecAvg = 0, maxConsistencyRegAvg = 0;

					float sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;

					ArrayList<Float> homeScoredRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> awayScoredRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> homeConcededRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> awayConcededRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> homeFormRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> awayFormRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> minConsistencyRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> maxConsistencyRecAvgArr = new ArrayList<Float>();

					for (i = 0; i < homeForm.size(); i++) {

						homeGoalTemp = homeGoals.get(i);
						homeOppGoalTemp = homeOppGoals.get(i);

						homeTotal = homeGoalTemp + homeOppGoalTemp;

						if (homeTotal > minBetThis)
							minConsistency.add(1);
						else
							minConsistency.add(0);

						if (homeTotal > maxBetThis)
							maxConsistency.add(1);
						else
							maxConsistency.add(0);

					}

					for (i = 0; i < homeForm.size(); i++) {

						sum1 += homeGoals.get(i);
						homeScoredRecAvgArr.add(sum1 / (i + 1));

						sum2 += homeOppGoals.get(i);
						homeConcededRecAvgArr.add(sum2 / (i + 1));

						sum3 += homeForm.get(i);
						homeFormRecAvgArr.add(sum3 / (i + 1));

						sum4 += minConsistency.get(i);
						minConsistencyRecAvgArr.add(sum4 / (i + 1));

						sum5 += maxConsistency.get(i);
						maxConsistencyRecAvgArr.add(sum5 / (i + 1));

					}

					homeScoredRegAvg = sum1 / homeForm.size();
					homeConcededRegAvg = sum2 / homeForm.size();
					homeFormRegAvg = sum3 / homeForm.size();
					minConsistencyRegAvg = sum4 / homeForm.size();
					maxConsistencyRegAvg = sum5 / homeForm.size();

					sum1 = 0;
					sum2 = 0;
					sum3 = 0;
					sum4 = 0;
					sum5 = 0;

					for (i = 0; i < homeForm.size(); i++) {

						sum1 += homeScoredRecAvgArr.get(i);
						sum2 += homeConcededRecAvgArr.get(i);
						sum3 += homeFormRecAvgArr.get(i);
						sum4 += minConsistencyRecAvgArr.get(i);
						sum5 += maxConsistencyRecAvgArr.get(i);

					}

					homeScoredRecAvg = sum1 / homeForm.size();
					homeConcededRecAvg = sum2 / homeForm.size();
					homeFormRecAvg = sum3 / homeForm.size();
					minConsistencyRecAvg = sum4 / homeForm.size();
					maxConsistencyRecAvg = sum5 / homeForm.size();

					homeFormRecProb = homeFormRecAvg;
					float homeScoredRecProb = homeScoredRecAvg;
					float homeConcededRecProb = homeConcededRecAvg;
					homeMinConsistencyRecProb = minConsistencyRecAvg;
					homeMaxConsistencyRecProb = maxConsistencyRecAvg;

					sum1 = 0;
					sum2 = 0;
					sum3 = 0;
					sum4 = 0;
					sum5 = 0;
					minConsistency.clear();
					maxConsistency.clear();
					minConsistencyRecAvgArr.clear();
					maxConsistencyRecAvgArr.clear();

					for (i = 0; i < awayForm.size(); i++) {

						awayGoalTemp = awayGoals.get(i);
						awayOppGoalTemp = awayOppGoals.get(i);

						awayTotal = awayGoalTemp + awayOppGoalTemp;

						if (awayTotal > minBetThis)
							minConsistency.add(1);
						else
							minConsistency.add(0);

						if (awayTotal > maxBetThis)
							maxConsistency.add(1);
						else
							maxConsistency.add(0);

					}

					for (i = 0; i < awayForm.size(); i++) {

						sum1 += awayGoals.get(i);
						awayScoredRecAvgArr.add(sum1 / (i + 1));

						sum2 += awayOppGoals.get(i);
						awayConcededRecAvgArr.add(sum2 / (i + 1));

						sum3 += awayForm.get(i);
						awayFormRecAvgArr.add(sum3 / (i + 1));

						sum4 += minConsistency.get(i);
						minConsistencyRecAvgArr.add(sum4 / (i + 1));

						sum5 += maxConsistency.get(i);
						maxConsistencyRecAvgArr.add(sum5 / (i + 1));

					}

					awayScoredRegAvg = sum1 / awayForm.size();
					awayConcededRegAvg = sum2 / awayForm.size();
					awayFormRegAvg = sum3 / awayForm.size();
					minConsistencyRegAvg = sum4 / awayForm.size();
					maxConsistencyRegAvg = sum5 / awayForm.size();

					sum1 = 0;
					sum2 = 0;
					sum3 = 0;
					sum4 = 0;
					sum5 = 0;

					for (i = 0; i < awayForm.size(); i++) {

						sum1 += awayScoredRecAvgArr.get(i);
						sum2 += awayConcededRecAvgArr.get(i);
						sum3 += awayFormRecAvgArr.get(i);
						sum4 += minConsistencyRecAvgArr.get(i);
						sum5 += maxConsistencyRecAvgArr.get(i);

					}

					awayScoredRecAvg = sum1 / awayForm.size();
					awayConcededRecAvg = sum2 / awayForm.size();
					awayFormRecAvg = sum3 / awayForm.size();
					minConsistencyRecAvg = sum4 / awayForm.size();
					maxConsistencyRecAvg = sum5 / awayForm.size();

					awayFormRecProb = awayFormRecAvg;
					float awayScoredRecProb = awayScoredRecAvg;
					float awayConcededRecProb = awayConcededRecAvg;
					awayMinConsistencyRecProb = minConsistencyRecAvg;
					awayMaxConsistencyRecProb = maxConsistencyRecAvg;

					homeExpectedRecProb = (homeScoredRecProb + awayConcededRecProb) / 2;
					awayExpectedRecProb = (awayScoredRecProb + homeConcededRecProb) / 2;

					if (neutral) {

						neutralHomeExpectedRecProb = homeExpectedRecProb;
						neutralAwayExpectedRecProb = awayExpectedRecProb;

						neutralHomeFormRecProb = homeFormRecProb;
						neutralAwayFormRecProb = awayFormRecProb;

						neutralAwayScoredRecProb = awayScoredRecAvg;
						neutralAwayConcededRecProb = awayConcededRecAvg;
						neutralAwayMinConsistencyRecProb = awayMinConsistencyRecProb;
						neutralAwayMaxConsistencyRecProb = awayMaxConsistencyRecProb;
						neutralHomeScoredRecProb = awayScoredRecAvg;
						neutralHomeConcededRecProb = awayConcededRecAvg;
						neutralHomeMinConsistencyRecProb = homeMinConsistencyRecProb;
						neutralHomeMaxConsistencyRecProb = homeMaxConsistencyRecProb;

						neutralMaxForm = Math.max(homeFormRecProb, awayFormRecProb);

						neutralHomeGoals.addAll(homeGoals);
						neutralAwayGoals.addAll(awayGoals);

					}

					neutral = false;

				} // h/a for loop

				float totalHomeExpectedRecProb = (homeExpectedRecProb + neutralHomeExpectedRecProb) / 2;
				float totalAwayExpectedRecProb = (awayExpectedRecProb + neutralAwayExpectedRecProb) / 2;
				float totalExpectedRecProb = totalHomeExpectedRecProb + totalAwayExpectedRecProb;
				float totalHomeForm = (homeFormRecProb + neutralHomeFormRecProb) / 2;
				float totalAwayForm = (awayFormRecProb + neutralAwayFormRecProb) / 2;
				float totalAwayMinConsistency = (awayMinConsistencyRecProb + neutralAwayMinConsistencyRecProb) / 2;
				float totalHomeMinConsistency = (homeMinConsistencyRecProb + neutralHomeMinConsistencyRecProb) / 2;

				float totalMinConsistency = Math.min(totalHomeMinConsistency,totalAwayMinConsistency);

				float totalAwayMaxConsistency = (awayMaxConsistencyRecProb + neutralAwayMaxConsistencyRecProb) / 2;
				float totalHomeMaxConsistency = (homeMaxConsistencyRecProb + neutralHomeMaxConsistencyRecProb) / 2;

				float totalMaxConsistency = (totalHomeMaxConsistency + totalAwayMaxConsistency) / 2;

				if (totalMinConsistency > 0.6999

						
				) {
					myWriter.write(date + " " + time);
					myWriter.write(",");
					myWriter.write(homeName);
					myWriter.write(",");
					myWriter.write(awayName);
					myWriter.write(",");
					myWriter.write("");
					myWriter.write(",");
					myWriter.write(Float.toString(totalHomeForm));
					myWriter.write(",");
					myWriter.write(Float.toString(totalAwayForm));
					myWriter.write(",");
					myWriter.write(Double.toString(totalExpectedRecProb));
					myWriter.write(",");
					myWriter.write(Double.toString(totalMaxConsistency));
					myWriter.write(",");
					myWriter.write("");
					myWriter.write(",");
					myWriter.write(link);

					myWriter.write(System.lineSeparator()); // new line

					System.out.println();

					System.out.println(link);
					System.out.println(date + " " + time);
					System.out.format("|%-25s|", league2);
					System.out.format("|%-25s|", homeName);
					System.out.format("|%-25s|", awayName);
					System.out.format("|%-25s|", "");

					System.out.println();
					System.out.format("|%-25s|", "Form");
					System.out.format("|%-25s|", totalHomeForm);
					System.out.format("|%-25s|", totalAwayForm);
					System.out.format("|%-25s|", "");
					System.out.println();

					System.out.format("|%-25s|", "Actual Points");
					System.out.format("|%-25s|", homeScore);
					System.out.format("|%-25s|", awayScore);
					System.out.format("|%-25s|", matchTotalScore);
					System.out.println();
					System.out.format("|%-25s|", "Expect Points");
					System.out.format("|%-25s|", totalHomeExpectedRecProb);
					System.out.format("|%-25s|", totalAwayExpectedRecProb);
					System.out.format("|%-25s|", totalExpectedRecProb);
					System.out.println();
					System.out.format("|%-25s|", minBetThis + " Consistency");
					System.out.format("|%-25s|", totalHomeMinConsistency);
					System.out.format("|%-25s|", totalAwayMinConsistency);
					System.out.format("|%-25s|", totalMinConsistency);
					System.out.println();
					System.out.format("|%-25s|", maxBetThis + " Consistency");
					System.out.format("|%-25s|", totalHomeMaxConsistency);
					System.out.format("|%-25s|", totalAwayMaxConsistency);
					System.out.format("|%-25s|", totalMaxConsistency);
					System.out.println();
					System.out.format("|%-25s|", "Bet Over " + "");
					System.out.format("|%-25s|", "Tier -> " + "");

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
	// end class
}
