package legacy;
import java.util.List;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Livescore18Football {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// setting the driver executable
//        System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
//        EdgeOptions options = new EdgeOptions();
//
//        WebDriver driver = new EdgeDriver();

System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox"); // Bypass OS security model
options.addArguments("headless"); // Bypass OS security model
options.addArguments("--disable-extensions"); // Bypass OS security model

		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, 1);
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

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ArrayList<String> links = new ArrayList<String>();

		int i = 1;
		int h = 0;
		int linknum = 1;

		// String mode = "H/A Same";
		String games = "20";


        String bt = "Schedule"; 
		//String oddsOption = "Pre";
		boolean sameLeague = false;
		int startIndex = 0;
	    int endIndex = 1500;
    	String day = "f3";
		System.out.println("day = " + day);
		System.out.println("In League = " + sameLeague);
		System.out.println("startIndex = " + startIndex);
		System.out.println("endIndex = " + endIndex);

		Livescore18Football ls = new Livescore18Football();
//	 links = ls.scheduleGrab(driver,i,h,links, "11-2021-2022",2);
//links = ls.fixtureGrab(driver, i, h, links, wait, startIndex, endIndex, day, bt);


 //links.add("https://www.goaloo.site/football/al-wakra-vs-al-duhail/h2h-2327614");


		ListIterator<String> litr = null;
		litr = links.listIterator();

		while (litr.hasNext()) {
			String link = litr.next();

			System.out.println(link);

			try {
				driver.get(link);
			} catch (Exception e) {
				link = litr.next();
				driver.get(link);
			}
			System.out.println("link # (" + linknum + " / " + links.size() + ")");
			linknum++;

			boolean neutral = true;

			ArrayList<Integer> homeForm = new ArrayList<Integer>();
			ArrayList<Integer> awayForm = new ArrayList<Integer>();
			ArrayList<Integer> neutralHomeForm = new ArrayList<Integer>();
			ArrayList<Integer> neutralAwayForm = new ArrayList<Integer>();
			ArrayList<Integer> FThomeGoals = new ArrayList<Integer>();
			ArrayList<Integer> FThomeOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> FTawayGoals = new ArrayList<Integer>();
			ArrayList<Integer> FTawayOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> FTneutralHomeGoals = new ArrayList<Integer>();
			ArrayList<Integer> FTneutralAwayGoals = new ArrayList<Integer>();
			ArrayList<Integer> FTneutralHomeOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> FTneutralAwayOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> HThomeGoals = new ArrayList<Integer>();
			ArrayList<Integer> HThomeOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> HTawayGoals = new ArrayList<Integer>();
			ArrayList<Integer> HTawayOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> HTneutralHomeGoals = new ArrayList<Integer>();
			ArrayList<Integer> HTneutralAwayGoals = new ArrayList<Integer>();

			float FThomeExpectedRecProb = 0, FTawayExpectedRecProb = 0, FThomeScoredRecProb = 0,
					FTawayScoredRecProb = 0, FThomeConcededRecProb = 0, FTawayConcededRecProb = 0,
					FTtotalExpectedRecProb = 0, homeScoredAGoalExpectedRecProb = 0, awayScoredAGoalExpectedRecProb = 0,
					homeConcededAGoalExpectedRecProb = 0, awayConcededAGoalExpectedRecProb = 0, homeFormRecProb = 0,
					awayFormRecProb = 0, FThomeOneRecProb = 0, FThomeTwoRecProb = 0, FThomeThreeRecProb = 0,
					FThomeFourRecProb = 0, FTawayOneRecProb = 0, FTawayTwoRecProb = 0, FTawayThreeRecProb = 0,
					FTawayFourRecProb = 0, FTneutralHomeOneRecProb = 0, FTneutralHomeTwoRecProb = 0,
					FTneutralHomeThreeRecProb = 0, FTneutralHomeFourRecProb = 0, FTneutralAwayOneRecProb = 0,
					FTneutralAwayTwoRecProb = 0, FTneutralAwayThreeRecProb = 0, FTneutralAwayFourRecProb = 0,
					neutralHomeFormRecProb = 0, neutralAwayFormRecProb = 0, FTneutralHomeExpectedRecProb = 0,
					FTneutralAwayExpectedRecProb = 0, FTneutralHomeScoredRecProb = 0, FTneutralAwayScoredRecProb = 0,
					FTneutralHomeConcededRecProb = 0, FTneutralAwayConcededRecProb = 0,
					neutralHomeScoredAGoalExpectedRecProb = 0, neutralAwayScoredAGoalExpectedRecProb = 0,
					neutralHomeConcededAGoalExpectedRecProb = 0, neutralAwayConcededAGoalExpectedRecProb = 0,
							homeScoredAGoalRecProb = 0, homeConcededAGoalRecProb = 0, awayScoredAGoalRecProb = 0,
							awayConcededAGoalRecProb = 0,

					FThomeExpectedRegProb = 0, FTawayExpectedRegProb = 0, FThomeScoredRegProb = 0,
					FTawayScoredRegProb = 0, FThomeConcededRegProb = 0, FTawayConcededRegProb = 0,
					FTtotalExpectedRegProb = 0,

					homeFormRegProb = 0, awayFormRegProb = 0, formDiffReg = 0, FThomeOneRegProb = 0,
					FThomeTwoRegProb = 0, FThomeThreeRegProb = 0, FThomeFourRegProb = 0, FTawayOneRegProb = 0,
					FTawayTwoRegProb = 0, FTawayThreeRegProb = 0, FTawayFourRegProb = 0, FTneutralHomeOneRegProb = 0,
					FTneutralHomeTwoRegProb = 0, FTneutralHomeThreeRegProb = 0, FTneutralHomeFourRegProb = 0,
					FTneutralAwayOneRegProb = 0, FTneutralAwayTwoRegProb = 0, FTneutralAwayThreeRegProb = 0,
					FTneutralAwayFourRegProb = 0, neutralHomeFormRegProb = 0, neutralAwayFormRegProb = 0,
					FTneutralHomeExpectedRegProb = 0, FTneutralAwayExpectedRegProb = 0, FTneutralHomeScoredRegProb = 0,
					FTneutralAwayScoredRegProb = 0, FTneutralHomeConcededRegProb = 0, FTneutralAwayConcededRegProb = 0,
					neutralHomeScoredAGoalExpectedRegProb = 0, neutralAwayScoredAGoalExpectedRegProb = 0,
					neutralHomeConcededAGoalExpectedRegProb = 0, neutralAwayConcededAGoalExpectedRegProb = 0,
					homeScoredAGoalRegProb = 0, homeConcededAGoalRegProb = 0, awayScoredAGoalRegProb = 0,
					awayConcededAGoalRegProb = 0,

					HThomeExpectedRecProb = 0, HTawayExpectedRecProb = 0, HThomeScoredRecProb = 0,
					HTawayScoredRecProb = 0, HThomeConcededRecProb = 0, HTawayConcededRecProb = 0,
					HTtotalExpectedProb = 0, HTtotalExpectedRecProb = 0, HThomeOneRecProb = 0, HTawayOneRecProb = 0,
					HTneutralHomeOneRecProb = 0, HTneutralAwayOneRecProb = 0, HTneutralHomeExpectedRecProb = 0,
					HTneutralAwayExpectedRecProb = 0, HTneutralHomeScoredRecProb = 0, HTneutralAwayScoredRecProb = 0,
					HTneutralHomeConcededRecProb = 0, HTneutralAwayConcededRecProb = 0,
					HTneutralTotalExpectedRecProb = 0, HThomeExpectedRegProb = 0, HTawayExpectedRegProb = 0,
					HThomeScoredRegProb = 0, HTawayScoredRegProb = 0, HThomeConcededRegProb = 0,
					HTawayConcededRegProb = 0, HTtotalExpectedRegProb = 0, HThomeOneRegProb = 0, HTawayOneRegProb = 0,
					HTneutralHomeOneRegProb = 0, HTneutralAwayOneRegProb = 0, HTneutralHomeExpectedRegProb = 0,
					HTneutralAwayExpectedRegProb = 0, HTneutralHomeScoredRegProb = 0, HTneutralAwayScoredRegProb = 0,
					HTneutralHomeConcededRegProb = 0, HTneutralAwayConcededRegProb = 0,
					HTneutralTotalExpectedRegProb = 0;

			String homeName, awayName, homeTeamName, date, time = null, matchResult, matchType = "", matchTitle,
					matchDay, status, matchScore = "";
			int FThomeGoalTemp, FThomeOppGoalTemp, FTawayGoalTemp, FTawayOppGoalTemp, FThomeTotal, FTawayTotal,
					HThomeGoalTemp, HThomeOppGoalTemp, HTawayGoalTemp, HTawayOppGoalTemp, HThomeTotal, HTawayTotal,
					FThomeScore = 0, FTawayScore = 0, FTScore, HTScore, HThomeScore = 0, HTawayScore = 0;
			LocalDate todayDate = null;
			double homeDays = 0;
			double awayDays = 0;

			String league2;
			int leagueGameHome = 0, leagueGameAway = 0;
			boolean leagueGame = false;
			String tier = "";

			try {

				FThomeScore = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"liveHS\"]")).getText());

				FTawayScore = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"liveGS\"]")).getText());

				String StringHTScore = driver.findElement(By.xpath("//*[@id=\"liveHt\"]")).getText();


				HThomeScore = Integer.parseInt(StringHTScore.split(" - ")[0].replace("(", ""));

				HTawayScore = Integer.parseInt(StringHTScore.split(" - ")[1].replace(")", ""));

			} catch (Exception e) {
				// System.out.println(e);

			}

			FTScore = FThomeScore + FTawayScore;
			HTScore = HThomeScore + HTawayScore;

			try {

				// get matchTitle
				league2 = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[1]/div[1]/a/div")).getText();
				System.out.println("matchTitle = " + league2);

				try {
					// get time of game
					date = driver.findElement(By.xpath("//*[@id='liveMt']")).getText();

					String[] dateSplit = date.split(" ");
					date = dateSplit[0];
					time = dateSplit[1];
					todayDate = LocalDate.parse(date.substring(0, 10), formatter2);
					status = driver.findElement(By.xpath("//*[@id='liveSt']")).getText();

					if (status.equals("Postp."))
						continue;

				} catch (Exception e) {
					date = driver.findElement(By.xpath("//*[@id='liveSt']")).getText();
					System.out.println(date);

					todayDate = LocalDate.now();
					System.out.println(todayDate);

					// System.out.println(e);
				}

				// get home name
				homeName = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[2]/div[1]/span/span")).getText();
				 System.out.println("homeName = " + homeName );

				// get away name
				awayName = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[2]/div[3]/span/span")).getText();
				 System.out.println("awayName = " + awayName );

				// ================== LEAGUE & TEAM BLACKLIST
				// ======================================================

				if (league2.contains("Brasileiro, Serie C"))
					league2 = "Brasileiro Serie C";

				if (league2.contains("Albania Super league") || league2.contains("Algeria Ligue Professionnelle 1")
						|| league2.contains("Algerian Ligue Professionnelle 1")

						|| league2.contains("Argentine Division") || league2.contains("Australia A-League")
						|| league2.contains("Austrian Bundesliga") || league2.contains("Azerbaijan Premier League")
						|| league2.contains("Belarusian Premier League") || league2.contains("Belgian Pro League")
						|| league2.contains("Bolivia Primera Division") || league2.contains("Qatar League")

						|| league2.contains("Bosnia and Herzgovina Premier League")
						|| league2.contains("Brazil Serie A") || league2.contains("Serie C")
						|| league2.contains("Ukrainian Premier League")
						|| league2.contains("Brazil Campeonato Paulista")
						|| league2.contains("Brazil Campeonato Mineiro Division 1")
						|| league2.contains("Brazil Campeonato Carioca")
						|| league2.contains("Brazil Pernambucano League") || league2.contains("Brazil Paraibano")
						|| league2.contains("Bra CaP") || league2.contains("Bulgaria Premier League")
						|| league2.contains("Canadian Premier League") || league2.contains("Chile Primera Division")
						|| league2.contains("Chinese Super League")
						|| league2.contains("Primera Division de Colombiano")
						|| league2.contains("Costa Rica Primera Division") || league2.contains("Croatia 1.Division")
						|| league2.contains("Cyprus 1 Division") || league2.contains("Czech Republic Gambrinus Liga")
						|| league2.contains("Danish 1st Division") || league2.contains("Primera Division de Ecuador")
						|| league2.contains("Egyptian Premier League") || league2.contains("English Premier League")
						|| league2.contains("Finland Veikkausliga") || league2.contains("Egyptian Premier League")
						|| league2.contains("France Ligue 1") || league2.contains("German Bundesliga")
						|| league2.contains("Greece Super League A") || league2.contains("Greece National B")
						|| league2.contains("Primera Division de Honduras")
						|| league2.contains("Hong Kong Premier League") || league2.contains("Hungary Borsodi Liga")
						|| league2.contains("Indian Super League") || league2.contains("Indonesia Liga 1")
						|| league2.contains("Persian Gulf Pro League") || league2.contains("Israel Premier League")
						|| league2.contains("Israel Leumit League") || league2.contains("Italian Serie A")
						|| league2.contains("J-League Division 1") || league2.contains("Jordan Premier League")
						|| league2.contains("Kazakhstan Premier League") || league2.contains("Liga Super Malaysia")
						|| league2.contains("Primera Division Liga MX") || league2.contains("Moldova Divizia Nationala")
						|| league2.contains("Botola Pro 1") || league2.contains("Myanmar Professional League")
						|| league2.contains("Holland Eredivisie") || league2.contains("Nigerian Premier League")
						|| league2.contains("Norwegian Tippeligaen") || league2.contains("Primera Division de Paraguay")
						|| league2.contains("Peru Primera Division") || league2.contains("Poland Ekstraklasa")
						|| league2.contains("Portugal Primeira Liga") || league2.contains("Romania Liga I")
						|| league2.contains("Russia Premier League") || league2.contains("Scottish Premier League")
						|| league2.contains("Serbian Superliga") || league2.contains("Singapore League")
						|| league2.contains("Slovak Super Liga") || league2.contains("Slovenia 1.Liga")
						|| league2.contains("South Africa Premier Soccer League") || league2.contains("Korea League 1")
						|| league2.contains("Spanish La Liga") || league2.contains("Swiss Super League")
						|| league2.contains("Thai Premier League") || league2.contains("Professional Tunisian League 1")
						|| league2.contains("Turkey Super Lig") || league2.contains("Ukraine Premier League")
						|| league2.contains("USA Major League Soccer") || league2.contains("Uruguay Primera Division")
						|| league2.contains("Primera Division de Venezuela") || league2.contains("Liga Portugal 1")
						|| league2.contains("Switzerland Super League")

						|| league2.contains("Poland Liga 1") || league2.contains("Saudi Professional League")
						|| league2.contains("UAE Pro-League") || league2.contains("Denmark Superligaen")
						|| league2.contains("Korea League") || league2.contains("Swedish Allsvenskan")
						|| league2.contains("Bosnia and Herzegovina Premier League")
						|| league2.contains("CONCACAF Champions League")
						|| league2.contains("CONMEBOL Champions League") || league2.contains("Copa Libertadores")

						|| league2.contains("UEFA Champions League") || league2.contains("AFC Champions League")
						|| league2.contains("CAF Champions League") || league2.contains("K League 1")
						|| league2.contains("J1 League") || league2.contains("Primera Division Liga MX")
						|| league2.contains("Kuwaiti Premier League") || league2.contains("V.League 1")

						|| league2.contains("Colombia Copa Premier") || league2.contains("Palestine Football League")
						|| league2.contains("UEFA Europa League") || league2.contains("UEFA Europa Conference League")
						|| league2.contains("Conmebol - Copa Sudamericana") || league2.contains("Copa Sudamericana")

						|| league2.contains("German Bundesliga 2") || league2.contains("Portugal Segunda Liga")
						|| league2.contains("Mexico Primera Divison A") || league2.contains("Mexico Primera Division A")
						|| league2.contains("Scottish Championship") || league2.contains("Ukraine Divison 2")
						|| league2.contains("USL Championship") || league2.contains("Italian Serie B")
						|| league2.contains("England Championship") || league2.contains("Brazil Serie B")
						|| league2.contains("Serbia Prva Liga") || league2.contains("CONCACAF League")
						|| league2.contains("Belgian Second") || league2.contains("Algeria Ligue Professionnelle 1")
						|| league2.contains("K League Challenge League") || league2.contains("J-League Division 2")
						|| league2.contains("Algerian Ligue Professionnelle 2") || league2.contains("Serbian Prva Liga")
						|| league2.contains("Spanish Segunda Division") || league2.contains("Argentine Division 2")
						|| league2.contains("Poland Division 2") || league2.contains("J2 League")
						|| league2.contains("Chinese Football Association Jia League")
						|| league2.contains("Austria Erste Division") || league2.contains("Holland Eerste Divisie")
						|| league2.contains("Liga Portugal 2") || league2.contains("Ukraine Division 2")
						|| league2.contains("France Ligue 3") || league2.contains("Scottish Division One")
						|| league2.contains("German 3.Liga") || league2.contains("England League 1")
						|| league2.contains("Brazil Serie C") || league2.contains("J-League Division 3")
						|| league2.contains("Italy C1") || league2.contains("Scottish Division Two")
						|| league2.contains("England League 2") || league2.contains("Peru B League")
						|| league2.contains("USA MLS Next Pro League")

				) {
					tier = "A";
				}
				if (

				league2.contains("Paraguayan Division 2") || league2.contains("Czech Republic 2.Liga")
						|| league2.contains("Indonesia Division 1")
						|| league2.contains("Kuwait first Division")
						|| league2.contains("Macedonian First Football League")
						|| league2.contains("Mongolia Premier League") || league2.contains("Welsh Premier League")
						|| league2.contains("Israel Leumit League") || league2.contains("Cameroon Elite One")
						|| league2.contains("Primera Division de El Salvador") || league2.contains("Slovakia 2. Liga")
						|| league2.contains("Norway Adeccoligaen") || league2.contains("Maldives Premier League")
						|| league2.contains("Sweden Superettan") || league2.contains("Malaysia Premier League")
						|| league2.contains("Iraqi Premier League") || league2.contains("Belarus Pershaya Liga")

						|| league2.contains("France Ligue 2")
						|| league2.contains("Hungary NB")
						|| league2.contains("Burundi")

						|| league2.contains("Vietnamese First Division")

						|| league2.contains("Cyprus 2 Division")

						|| league2.contains("Turkmenistan Premier League")
						|| league2.contains("Switzerland Challenge League")
						|| league2.contains("South Africa First League") || league2.contains("Malawi Premier League")
						|| league2.contains("Kosovo Division 1") || league2.contains("Cambodian Premier League")
						|| league2.contains("New Zealand Football Championship")
						|| league2.contains("Solomon Islands S League")
						|| league2.contains("Hong Kong First Division League")

						|| league2.contains("Kazakhstan Division 1") || league2.contains("Jordan League Division 1")
						|| league2.contains("Hungary NB II") || league2.contains("Brazil Campeonato Maranhense")
						|| league2.contains("Faroe Islands Formuladeildin")
						|| league2.contains("Estonia Champions League")
						|| league2.contains("Northern Ireland Premier League")
										|| league2.contains("Faroe Islands Formuladeildin") || league2.contains("Kenya Premier League")
						|| league2.contains("Uganda Premier League") || league2.contains("Saudi Arabia Division 1")
						|| league2.contains("Saudi Arabia Division 2")
						|| league2.contains("Australia Capital Gatorade Premier League")
						|| league2.contains("Puerto Rico League") || league2.contains("Chile Primera B")
						|| league2.contains("Panama Liga Nacional de Ascenso") || league2.contains("Costa Rica 2.Liga")
						|| league2.contains("Tanzania Ligue 1") || league2.contains("Kyrgyzstan Top Liga")
						|| league2.contains("Bhutan Premier League") || league2.contains("Uzbek League")
						|| league2.contains("Egypt Division 2") || league2.contains("Mauritania Division 1")
						|| league2.contains("Croatia 2.HNL") 
						|| league2.contains("Southeast Asian Games")

						|| league2.contains("Thai Division 1 League") || league2.contains("Kampuchea Super League")
						|| league2.contains("Kenya Super League") || league2.contains("Slovenia 2.Liga")
						|| league2.contains("Ethiopia Premier League")

						|| league2.contains("Oman Professional League") || league2.contains("Uruguay Segunda")
						|| league2.contains("BRA SPC")

						|| league2.contains("India League Division 1") || league2.contains("Burkina Faso League")
						|| league2.contains("Syrian League") || league2.contains("BRA SPB")
						|| league2.contains("Azerbaijan Division 2") || league2.contains("Liga de Elite")
						|| league2.contains("TAS Premier League") || league2.contains("NSW-N Premier League")
						|| league2.contains("VIC Premier League") || league2.contains("QLD Premier League")
						|| league2.contains("Swiss Challenge League") || league2.contains("Lithuania - 1.Division")

						|| league2.contains("Russian National Football League") || league2.contains("Slovakia 2.Liga")

						|| league2.contains("Latvian Higher League") || league2.contains("Aruba Division Di Honor")

						|| league2.contains("BRA CP") 	|| league2.contains("BRA CGD")
						|| league2.contains("San Marino League")
						|| league2.contains("Nicaragua Apertura league") || league2.contains("Greece Division C")
						|| league2.contains("Danish 1st Division") || league2.contains("Lebanese Premier League")
						|| league2.contains("Liga Nacional de Guatemala")

						|| league2.contains("UAE Division 1")

						|| league2.contains("National Premier Leagues Western Australia") || league2.contains("POL WD1")

						|| league2.contains("Romania - Liga 2 Seria") || league2.contains("Kosovo Superliga")
						|| league2.contains("Angola Girabola League") || league2.contains("NSW Premier League")
						|| league2.contains("Central Premier League") || league2.contains("Bulgaria B PFG")
						|| league2.contains("Azadegan League") || league2.contains("Liberia First Division")
						|| league2.contains("Mali Premiere Division") || league2.contains("Bahraini Premier League")
						|| league2.contains("Georgia Primera Division") || league2.contains("Bangladesh Premier League")
						|| league2.contains("Ivory Coast Premier Division") || league2.contains("Finland Ykkonen")
						|| league2.contains("Zimbabwe Premier") || league2.contains("Australia Darwin Premier League")
						|| league2.contains("Iceland Premier Division") || league2.contains("Ghana Premier League")
						|| league2.contains("Ireland Premier Division") || league2.contains("Jamaica Premier League")
						|| league2.contains("Turkey 1. Lig") || league2.contains("Armenia Premier League")
						|| league2.contains("Montenegro Prva Crnogorska Liga")
						|| league2.contains("Trinidad and Tobago Pro League")
						|| league2.contains("Brazil Paulista Serie B")
						|| league2.contains("Luxembourg National Division")
						|| league2.contains("Venezuela Segunda Division")
						|| league2.contains("Ecuador Campeonato Serie B")
						|| league2.contains("Tajikistan Vysshaya Liga") || league2.contains("Philippines UFL")
						|| league2.contains("Malta Premier League") || league2.contains("Rwanda National League")
						|| league2.contains("Brazil Campeonato Roraimense")

						|| league2.contains("Dominican Republic Liga")

						|| league2.contains("Andorra Primera")
						|| league2.contains("Australia New South Wales Super League")
						|| league2.contains("Gambia GFA League") || league2.contains("Northern New Zealand League")
						|| league2.contains("UAE Division 2")

						|| league2.contains("Andorra Super league")

						|| league2.contains("Qatar B")

						|| league2.contains("Botola 2") || league2.contains("Albania Division 2")
						|| league2.contains("Honduras Liga de Ascenso")
						|| league2.contains("Greece National B")
						|| league2.contains("Hong Kong 2nd Division")
						|| league2.contains("Chinese Taipei Intercity League")
						|| league2.contains("Gibraltar Premier Division")


				) {
					tier = "B";
				}
				if (

				league2.contains("Slovakia 3.Liga")
						|| league2.contains("El Salvador Segunda Division")
						|| league2.contains("Hong Kong 3rd Division")
						|| league2.contains("Lebanese Premier 2")

						|| league2.contains("Estonia Esi Liiga") || league2.contains("Finland - Kakkonen Lohko")
						|| league2.contains("Croatia 3.Division") || league2.contains("FFSA PL")
						|| league2.contains("Thai Division 2 League")
						|| league2.contains("Thai Division 2 League")

						|| league2.contains("Iceland Division 1") || league2.contains("Ireland First Division")
						|| league2.contains("Guatemala Segunda Division")

						|| league2.contains("Malta First Division League")
						|| league2.contains("Northern Ireland League")
						|| league2.contains("FYR Macedonia Vtora Fudbalska Liga")

						|| league2.contains("Andorra Segona") || league2.contains("Switzerland Promotion League")

						|| league2.contains("Bosnia erzegovina 1st League")

						|| league2.contains("Armenia Division 2") || league2.contains("Spain Primera Division RFEF")
						|| league2.contains("U23") || league2.contains("U-23")

						|| league2.contains("Brazil Campeonato Sergipano A2")

						|| league2.contains("Vietnam Second Division")

						|| league2.contains("Faroe Islands Division 1") || league2.contains("Iceland Division 2")

						|| league2.contains("Portugal Campeonato Nacional")

						|| league2.contains("Brazil Campeonato Gaucho 2") || league2.contains("Wales FAW Championship")
						|| league2.contains("Bhutan Thimphu League") || league2.contains("Austrian 3.Liga")

						|| league2.contains("Hungary NB III") || league2.contains("Nepal B Division")
						|| league2.contains("Nicaragua Segunda Division") || league2.contains("Mexico Segunda Division")
						|| league2.contains("Georgia Division") || league2.contains("Lithuania - 2.Division")

						|| league2.contains("Kazakhstan Division 2")

						|| league2.contains("Luxembourg Promotion DHonneur")

						|| league2.contains("Gambia Division 2") || league2.contains("Guatemala D2")

						|| league2.contains("Spanish Segunda Division B") || league2.contains("FFSA Premier League")

						|| league2.contains("Bangladesh Championship League")

						|| league2.contains("Bahrain Division 2") || league2.contains("Montenegro Division 2")

						|| league2.contains("Malaysia Liga M3")

						|| league2.contains("Denmark - 2.Liga")

						|| league2.contains("Greece Super League Women")
						|| league2.contains("National Primera Division Western Australia")

						|| league2.contains("Senegal Ligue 2")

						|| league2.contains("Romania - Liga 3 Seria")

						|| league2.contains("UAE RL") || league2.contains("Northern Ireland IFA Championship")
						|| league2.contains("Argentine Torneo A") || league2.contains("Slovenia 3.Liga")
						|| league2.contains("Canadian Championship")

						|| league2.contains("Greece Divison C") || league2.contains("Mongolia First League")

						|| league2.contains("Sweden Division 1") || league2.contains("Norway 2.Liga")
						|| league2.contains("Iceland 3 Deild") || league2.contains("Macau 2nd Division")
						|| league2.contains("Lithuania II Lyga")

						|| league2.contains("Australia Northern NSW Division 1")
						|| league2.contains("Sri Lanka Champions League")

						|| league2.contains("Russia Division 2") || league2.contains("Holland Ligue 3")

						|| league2.contains("New Zealand South Premier League")

						|| league2.contains("Korea Challengers League")
						|| league2.contains("Syria Division 2")
						 || league2.contains("Reserve") || league2.contains("USA USL League Two")
						|| league2.contains("USA Independent League") 
						|| league2.contains("Austrian 3.Liga") || league2.contains("Nicaragua Liga de Ascenso")
						|| league2.contains("Ukraine Division 3") || league2.contains("Portugal Liga 3")
						|| league2.contains("Bahrain Division")

				)
					tier = "C";

				if (

				league2.contains("FFSA SLR")

						|| league2.contains("Turkiye Lig3") || league2.contains("Brazil Campeonato Carioca C")
						|| league2.contains("Brazil Campeonato Potiguar 2")
						|| league2.contains("Brazil Campeonato Pernambucano A2")

						|| league2.contains("Latvia Division 2") || league2.contains("Turkey Bayanlar 1. Ligi")
						|| league2.contains("Japan Football League")

						|| league2.contains("Australia Victoria State League") || league2.contains("Regionalliga")
						|| league2.contains("Israel B League")

						|| league2.contains("Spain Segunda Division RFEF")
						|| league2.contains("Australia Queensland State Leagues")
						|| league2.contains("Australia Victoria State League 1") || league2.contains("Denmark - 4.Liga")
						|| league2.contains("Victorian State League Division 1")

						|| league2.contains("Mongolia Second League") || league2.contains("Panama Liga Prom")
						|| league2.contains("TAS Premier Championship") || league2.contains("Korea League 4")
						|| league2.contains("Australia Queensland Premier League 2") || league2.contains("BRA D4")
						|| league2.contains("Serie D")

						|| league2.contains("Holland Derde Divisie") || league2.contains("SAFF")

						|| league2.contains("Uzbekistan Second League") || league2.contains("Serie D")

						|| league2.contains("USA National Premier Soccer League")

						|| league2.contains("U22") || league2.contains("U-22")

						|| league2.contains("Denmark Division 3") || league2.contains("Estonia Teine Liiga")
						|| league2.contains("English Women's Conference South")
						|| league2.contains("Australia Brisbane Capital League 2")
						|| league2.contains("Portugal Champions NACIONAL")
						|| league2.contains("Ireland Leinster Senior League")

						|| league2.contains("India Shillong Premier League")
						|| league2.contains("India Bangalore Super Division")

						|| league2.contains("Calcutta Football League")

						|| league2.contains("India Mumbai Elite League")

						|| league2.contains("Denmark 2 Division Women") || league2.contains("Finland Kolmonen")
						|| league2.contains("Australia New South Wales League 2")
						|| league2.contains("Nepal C Division") || league2.contains("India Delhi Senior Division")
						|| league2.contains("Mexico Liga TDP") || league2.contains("Turkey 3")
						|| league2.contains("Argentina Prim C") || league2.contains("Landesliga")
						|| league2.contains("Argentina Torneo B")
						|| league2.contains("India Mizoram Premier League") || league2.equals("Chile Primera D")
						|| league2.contains("Germany Landespokal")
						|| league2.contains("International") || league2.contains("Cup") || league2.contains("CUP")
						|| league2.contains("CONCACAF Nations League") || league2.contains("UEFA Nations League")
						|| league2.contains("Coppa") || league2.contains("Pokal") || league2.contains("Vase")
						|| league2.contains("Johnstone") || league2.contains("Cupen") || league2.contains("cup")


				)
					tier = "D";

				if (league2.contains("Norway Division 4")

						|| league2.contains("Oberliga") || league2.contains("Brazil Copa Gaucho")

						|| league2.contains("England Northern League")
						|| league2.contains("England Ryman(Isthmian) League Premier Division")
						|| league2.contains("Czech Republic 5. Ligy") || league2.contains("Argentina Regional League")
						|| league2.contains("Israel C League") || league2.contains("Colombia Regional League")

						|| league2.contains("Australia Queensland Premier League 3")
						|| league2.contains("Australia Victorian Premier League U21")
						|| league2.contains("Brazil Debbie Shapiro") || league2.contains("GER D5")
						|| league2.contains("Sweden Div 3")

						|| league2.contains("The lowlands of Scotland League") || league2.contains("Iceland 4 Deild")
						|| league2.contains("Northern German state premier league - bayern")
						|| league2.contains("Czech Group D League")
						|| league2.contains("Czech Republic Ceska Fotbalova Liga")
						|| league2.contains("Czech Republic 5. Ligy")
						|| league2.contains("Italian Campionato Nazionale Primavera")
						|| league2.contains("Poland Division 4") || league2.contains("Tercera")
						|| league2.contains("Schleswig Holstein Liga")

						|| league2.contains("Australian cloth") || league2.contains("England Conference")

						|| league2.contains("Argentina group C")
						|| league2.contains("Argentina Ding Group Tebolidun League Manchester")

						
						|| league2.contains("Cuban Championship") || league2.contains("Germany Verbandsliga")

						|| league2.contains("U21") || league2.contains("U-21")
						|| league2.contains("U20") || league2.contains("U-20")

						|| league2.contains("Mexico GNP")		
						|| league2.contains(" Belgian First Amateur Division")		

						
						|| league2.contains("Campeonato Piauiense")		

						|| league2.contains("Turkey 3. Ligi B")
						|| league2.contains("AFF Championship")

						
						|| league2.contains("England Southern League Central Division")
						|| league2.contains("England Northern Premier League")
						|| league2.contains("England Ryman(Isthmian)")

						|| league2.contains("Women")
						|| league2.contains("Ladies")
						|| league2.contains("Feminines")

						|| league2.contains("WPL")
						|| league2.contains("England Southern Premier League")
						|| league2.contains("Femenil")
						|| league2.contains("Feminin")

						|| league2.contains("Friendly") 

						 || league2.contains("Youth")
						 || league2.contains("U19")
						 || league2.contains("U-19")
						 || league2.contains("Junior")

				)
					tier = "E";

				if (
						league2.contains("Russia")

						
	
						  || league2.contains("ENG SD1")
						  || league2.contains("Spanish Ladies Premier League B")
						  || league2.contains("Wales Premier League Women")
						  || league2.contains("Malta Women Division 1")
						  || league2.contains("Belgium Women's Premier League")
						  || league2.contains("German Frauen Bundesliga")
						  || league2.contains("Nacional Women")
						  || league2.contains("Nacional Women")

						  || league2.contains("El Salvador Reserves League")
						  || league2.contains("Brazil Campeonato Paulista C")
						  || league2.contains("Ireland Leinster Senior")
						  || league2.contains("Belgian Second Division")

				)
					continue;
				


				if (games.equals("20")) {
					// driver.findElement(By.xpath("//*[@i='f6']/div/span/select")).click();
					// driver.findElement(By.xpath("//*[@id='f6']/div/span/select/option[2]")).click();
					// driver.findElement(By.xpath("//*[@id='f6']/div/span/select")).click();
					driver.findElement(By.xpath("//*[@id='f6']/div/span/select/option[2]")).click();
				}

			


			// 	driver.findElement(By.xpath("//*[@id='f6']/div/span/label[1]")).click();

			 	String betType = "";
			// 	int exception = 0;

			// 	try {
			// 		matchType = driver.findElement(By
			// 		.xpath("(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[1]/div/div)["
			// 				+ 1 + "]"))
			// 		.getText();

			// matchDay = driver.findElement(By.xpath(
			// 		"(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[1]/div/span)[" + 1
			// 				+ "]"))
			// 		.getText();

			// LocalDate matchDate = LocalDate.parse(matchDay, formatter);
			// Period period = Period.between(matchDate, todayDate);
			// homeDays = period.getDays() + (period.getMonths() * 30.437) + (period.getYears() * 365.25);
			//  System.out.println("Days since last league match = " + homeDays );

	


			// 	matchType = driver.findElement(By
			// 						.xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[1]/div/div)["
			// 								+ 1 + "]"))
			// 						.getText();

			// 				matchDay = driver.findElement(By.xpath(
			// 						"(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[1]/div/span)[" + 1
			// 								+ "]"))
			// 						.getText();

			// 				matchDate = LocalDate.parse(matchDay, formatter);

			// 				period = Period.between(matchDate, todayDate);

			// 				awayDays = period.getDays() + (period.getMonths() * 30.437) + (period.getYears() * 365.25);
			// 			 System.out.println("Days since last league match = " + awayDays );

			// 				if(homeDays > 12 && awayDays > 12)
			// 				exception = 1;
						 
			// 	}catch(Exception e) {
			// 		exception = 1;

			// 	}
			// 				driver.findElement(By.xpath("//*[@id='f6']/div/span/label[1]")).click();


				for (int j = 0; j < 2; j++) {

					homeForm.clear();
					awayForm.clear();
					FThomeGoals.clear();
					FThomeOppGoals.clear();
					FTawayGoals.clear();
					FTawayOppGoals.clear();
					HThomeGoals.clear();
					HThomeOppGoals.clear();
					HTawayGoals.clear();
					HTawayOppGoals.clear();

					if (!neutral) {
						driver.findElement(By.xpath("//*[@id=\"f6\"]/div/span/label[2]")).click();
					}
					try {
						driver.findElement(By.xpath("//*[@id=\"f6\"]/div/span/label[2]")).click();
						driver.findElement(By.xpath("//*[@id=\"f6\"]/div/span/label[2]")).click();
						driver.findElement(By.xpath("//*[@id=\"f6\"]/div/span/label[2]")).click();
						driver.findElement(By.xpath("//*[@id=\"f6\"]/div/span/label[2]")).click();

					} catch (Exception e) {
						// System.out.println("No boxes to click");
						// System.out.println(e);

						// continue;
					}

					// get home avg
					i = 1;

					while (true) {
						try {

							matchType = driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[1]/div/div)["
											+ i + "]"))
									.getText();

							matchDay = driver.findElement(By.xpath(
									"(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[1]/div/span)[" + i
											+ "]"))
									.getText();

							
							// System.out.println("Days since last match = " + days );



							// if( leagueGameHome < 1)
							// break;

//                            if (days > 91.311) {
//                                i++;
//                                continue;
//                            }

							matchResult = driver.findElement(By.xpath(
									"(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[4])[" + i + "]"))
									.getAttribute("data-cls");

							FThomeGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[4]/span[1])["
											+ i + "]"))
									.getText());

							FThomeOppGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[4]/span[2])["
											+ i + "]"))
									.getText());

							HThomeGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[3]/span[1])["
											+ i + "]"))
									.getText());

							HThomeOppGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[1]//tr[@style='display: table-row;']/td[3]/span[2])["
											+ i + "]"))
									.getText());

							if (matchResult.equals("o-winBGp")) {
								homeForm.add(3);
								if (FThomeGoalTemp > FThomeOppGoalTemp) {
									FThomeGoals.add(FThomeGoalTemp);
									FThomeOppGoals.add(FThomeOppGoalTemp);
									HThomeGoals.add(HThomeGoalTemp);
									HThomeOppGoals.add(HThomeOppGoalTemp);

								} else {
									FThomeGoals.add(FThomeOppGoalTemp);
									FThomeOppGoals.add(FThomeGoalTemp);
									HThomeGoals.add(HThomeOppGoalTemp);
									HThomeOppGoals.add(HThomeGoalTemp);
								}

							} else if (matchResult.equals("o-voidBGp")) {
								homeForm.add(1);
								FThomeGoals.add(FThomeGoalTemp);
								FThomeOppGoals.add(FThomeOppGoalTemp);
								HThomeGoals.add(HThomeGoalTemp);
								HThomeOppGoals.add(HThomeOppGoalTemp);

							} else if (matchResult.equals("o-lossBGp")) {
								homeForm.add(0);
								if (FThomeGoalTemp > FThomeOppGoalTemp) {
									FThomeGoals.add(FThomeOppGoalTemp);
									FThomeOppGoals.add(FThomeGoalTemp);
									HThomeGoals.add(HThomeOppGoalTemp);
									HThomeOppGoals.add(HThomeGoalTemp);

								} else {
									FThomeGoals.add(FThomeGoalTemp);
									FThomeOppGoals.add(FThomeOppGoalTemp);
									HThomeGoals.add(HThomeGoalTemp);
									HThomeOppGoals.add(HThomeOppGoalTemp);

								}

							}

							i++;

						} catch (Exception e) {
							// System.out.println("no more home goals");
							// System.out.println(e);
							break;
						}
					}

					leagueGame = false;
					i = 1;
					while (true) {
						try {

							matchType = driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[1]/div/div)["
											+ i + "]"))
									.getText();

							matchDay = driver.findElement(By.xpath(
									"(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[1]/div/span)[" + i
											+ "]"))
									.getText();

						



							// if( leagueGameAway < 1)
							// break;

//                            if (days > 91.311) {
//                                i++;
//                                continue;
//
//                            }

							matchResult = driver.findElement(By.xpath(
									"(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[4])[" + i + "]"))
									.getAttribute("data-cls");

							// System.out.println("away match result = " + matchResult);

							FTawayGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[4]/span[1])["
											+ i + "]"))
									.getText());


							FTawayOppGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[4]/span[2])["
											+ i + "]"))
									.getText());

							HTawayGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[3]/span[1])["
											+ i + "]"))
									.getText());


							HTawayOppGoalTemp = Integer.valueOf(driver.findElement(By
									.xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[3]/span[2])["
											+ i + "]"))
									.getText());

							if (matchResult.equals("o-winBGp")) {
								awayForm.add(3);
								if (FTawayGoalTemp > FTawayOppGoalTemp) {
									FTawayGoals.add(FTawayGoalTemp);
									FTawayOppGoals.add(FTawayOppGoalTemp);
									HTawayGoals.add(HTawayGoalTemp);
									HTawayOppGoals.add(HTawayOppGoalTemp);
								} else {

									FTawayGoals.add(FTawayOppGoalTemp);
									FTawayOppGoals.add(FTawayGoalTemp);
									HTawayGoals.add(HTawayOppGoalTemp);
									HTawayOppGoals.add(HTawayGoalTemp);

								}

							} else if (matchResult.equals("o-voidBGp")) {
								awayForm.add(1);
								FTawayGoals.add(FTawayGoalTemp);
								FTawayOppGoals.add(FTawayOppGoalTemp);
								HTawayGoals.add(HTawayGoalTemp);
								HTawayOppGoals.add(HTawayOppGoalTemp);

							} else if (matchResult.equals("o-lossBGp")) {
								awayForm.add(0);
								if (FTawayGoalTemp > FTawayOppGoalTemp) {
									FTawayGoals.add(FTawayOppGoalTemp);
									FTawayOppGoals.add(FTawayGoalTemp);
								} else {
									FTawayGoals.add(FTawayGoalTemp);
									FTawayOppGoals.add(FTawayOppGoalTemp);
								}
								HTawayGoals.add(HTawayGoalTemp);
								HTawayOppGoals.add(HTawayOppGoalTemp);
							}

							i++;

						} catch (Exception e) {
							// System.out.println("no more away goals");
							// System.out.println(e);
							break;
						}
					}

					ArrayList<Integer> FToneCount = new ArrayList<Integer>();
					ArrayList<Integer> FTtwoCount = new ArrayList<Integer>();
					ArrayList<Integer> FTthreeCount = new ArrayList<Integer>();
					ArrayList<Integer> FTfourCount = new ArrayList<Integer>();
					ArrayList<Integer> homeScoredAGoal = new ArrayList<Integer>();
					ArrayList<Integer> awayScoredAGoal = new ArrayList<Integer>();
					ArrayList<Integer> FThomeScored = new ArrayList<Integer>();
					ArrayList<Integer> FTawayScored = new ArrayList<Integer>();
					ArrayList<Integer> FThomeConceded = new ArrayList<Integer>();
					ArrayList<Integer> FTawayConceded = new ArrayList<Integer>();
					ArrayList<Integer> homeConcededAGoal = new ArrayList<Integer>();
					ArrayList<Integer> awayConcededAGoal = new ArrayList<Integer>();

					ArrayList<Integer> HToneCount = new ArrayList<Integer>();
					ArrayList<Integer> HThomeScored = new ArrayList<Integer>();
					ArrayList<Integer> HTawayScored = new ArrayList<Integer>();
					ArrayList<Integer> HThomeConceded = new ArrayList<Integer>();
					ArrayList<Integer> HTawayConceded = new ArrayList<Integer>();

					float FToneCountRecAvg = 0, FToneCountRegAvg = 0, FTtwoCountRecAvg = 0, FTtwoCountRegAvg = 0,
							FTthreeCountRecAvg = 0, FTthreeCountRegAvg = 0, FTfourCountRecAvg = 0,
							FTfourCountRegAvg = 0, FThomeScoredRecAvg = 0, FThomeScoredRegAvg = 0,
							FTawayScoredRecAvg = 0, FTawayScoredRegAvg = 0, FThomeConcededRecAvg = 0,
							FThomeConcededRegAvg = 0, FTawayConcededRecAvg = 0, FTawayConcededRegAvg = 0,
							homeFormRecAvg = 0, awayFormRecAvg = 0,

							HToneCountRecAvg = 0, HToneCountRegAvg = 0, HThomeScoredRecAvg = 0, HThomeScoredRegAvg = 0,
							HTawayScoredRecAvg = 0, HTawayScoredRegAvg = 0, HThomeConcededRecAvg = 0,
							HThomeConcededRegAvg = 0, HTawayConcededRecAvg = 0, HTawayConcededRegAvg = 0,

							homeFormRegAvg = 0, awayFormRegAvg = 0, homeScoredAGoalRecAvg = 0,
							awayScoredAGoalRecAvg = 0, homeConcededAGoalRecAvg = 0, awayConcededAGoalRecAvg = 0,
							homeScoredAGoalRegAvg = 0, awayScoredAGoalRegAvg = 0, homeConcededAGoalRegAvg = 0,
							awayConcededAGoalRegAvg = 0;

					for (i = 0; i < homeForm.size(); i++) {

						FThomeGoalTemp = FThomeGoals.get(i);
						FThomeOppGoalTemp = FThomeOppGoals.get(i);

						FThomeTotal = FThomeGoalTemp + FThomeOppGoalTemp;

						HThomeGoalTemp = HThomeGoals.get(i);
						HThomeOppGoalTemp = HThomeOppGoals.get(i);

						HThomeTotal = HThomeGoalTemp + HThomeOppGoalTemp;

						if (FThomeGoalTemp > 0)
							homeScoredAGoal.add(1);
						else
							homeScoredAGoal.add(0);

						if (FThomeOppGoalTemp > 0)
							homeConcededAGoal.add(1);
						else
							homeConcededAGoal.add(0);

						if (HThomeTotal == 0) {
							HToneCount.add(0);

						}
						if (HThomeTotal > 0) {
							HToneCount.add(1);

						}

						if (FThomeTotal == 0) {
							FToneCount.add(0);
							FTtwoCount.add(0);
							FTthreeCount.add(0);
							FTfourCount.add(0);
						}

						if (FThomeTotal == 1) {
							FToneCount.add(1);
							FTtwoCount.add(0);
							FTthreeCount.add(0);
							FTfourCount.add(0);
						}

						if (FThomeTotal == 2) {
							FToneCount.add(1);
							FTtwoCount.add(1);
							FTthreeCount.add(0);
							FTfourCount.add(0);
						}

						if (FThomeTotal == 3) {
							FToneCount.add(1);
							FTtwoCount.add(1);
							FTthreeCount.add(1);
							FTfourCount.add(0);
						}

						if (FThomeTotal >= 4) {
							FToneCount.add(1);
							FTtwoCount.add(1);
							FTthreeCount.add(1);
							FTfourCount.add(1);
						}

					}

					float sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0, sum6 = 0, sum7 = 0, sum8 = 0, sum9 = 0,
							sum10 = 0, sum11 = 0, sum12 = 0, sum13 = 0;

					ArrayList<Float> homeFormRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> awayFormRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> FToneCountRecAvgArr = new ArrayList<Float>();

					ArrayList<Float> FTtwoCountRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> FTthreeCountRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> FTfourCountRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> FThomeScoredRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> FTawayScoredRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> FThomeConcededRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> FTawayConcededRecAvgArr = new ArrayList<Float>();

					ArrayList<Float> homeScoredAGoalRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> awayScoredAGoalRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> homeConcededAGoalRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> awayConcededAGoalRecAvgArr = new ArrayList<Float>();

					ArrayList<Float> HToneCountRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> HThomeScoredRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> HTawayScoredRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> HThomeConcededRecAvgArr = new ArrayList<Float>();
					ArrayList<Float> HTawayConcededRecAvgArr = new ArrayList<Float>();

					for (i = 0; i < homeForm.size(); i++) {

						sum1 += FToneCount.get(i);
						FToneCountRecAvgArr.add(sum1 / (i + 1));

						sum2 += FTtwoCount.get(i);
						FTtwoCountRecAvgArr.add(sum2 / (i + 1));

						sum3 += FTthreeCount.get(i);
						FTthreeCountRecAvgArr.add(sum3 / (i + 1));

						sum4 += FTfourCount.get(i);
						FTfourCountRecAvgArr.add(sum4 / (i + 1));

						sum6 += FThomeGoals.get(i);
						FThomeScoredRecAvgArr.add(sum6 / (i + 1));

						sum7 += FThomeOppGoals.get(i);
						FThomeConcededRecAvgArr.add(sum7 / (i + 1));

						sum8 += homeScoredAGoal.get(i);
						homeScoredAGoalRecAvgArr.add(sum8 / (i + 1));

						sum9 += homeConcededAGoal.get(i);
						homeConcededAGoalRecAvgArr.add(sum9 / (i + 1));

						sum10 += homeForm.get(i);
						homeFormRecAvgArr.add(sum10 / (i + 1));

						sum11 += HThomeGoals.get(i);
						HThomeScoredRecAvgArr.add(sum11 / (i + 1));

						sum12 += HThomeOppGoals.get(i);
						HThomeConcededRecAvgArr.add(sum12 / (i + 1));

						sum13 += HToneCount.get(i);
						HToneCountRecAvgArr.add(sum13 / (i + 1));

					}

					FToneCountRegAvg = sum1 / homeForm.size();

					FTtwoCountRegAvg = sum2 / homeForm.size();
					FTthreeCountRegAvg = sum3 / homeForm.size();
					FTfourCountRegAvg = sum4 / homeForm.size();
					FThomeScoredRegAvg = sum6 / homeForm.size();
					FThomeConcededRegAvg = sum7 / homeForm.size();

					FThomeScoredRegAvg = sum6 / homeForm.size();
					FThomeConcededRegAvg = sum7 / homeForm.size();

					homeScoredAGoalRegAvg = sum8 / homeForm.size();
					homeConcededAGoalRegAvg = sum9 / homeForm.size();
					homeFormRegAvg = sum10 / homeForm.size();

					HThomeScoredRegAvg = sum11 / homeForm.size();
					HThomeConcededRegAvg = sum12 / homeForm.size();
					HToneCountRegAvg = sum13 / homeForm.size();

					sum1 = 0;
					sum2 = 0;
					sum3 = 0;
					sum4 = 0;
					sum5 = 0;
					sum6 = 0;
					sum7 = 0;
					sum8 = 0;
					sum9 = 0;
					sum10 = 0;
					sum11 = 0;
					sum12 = 0;
					sum13 = 0;

					for (i = 0; i < homeForm.size(); i++) {

						sum1 += FToneCountRecAvgArr.get(i);

						sum2 += FTtwoCountRecAvgArr.get(i);
						sum3 += FTthreeCountRecAvgArr.get(i);
						sum4 += FTfourCountRecAvgArr.get(i);
						sum6 += FThomeScoredRecAvgArr.get(i);
						sum7 += FThomeConcededRecAvgArr.get(i);

						sum8 += homeScoredAGoalRecAvgArr.get(i);
						sum9 += homeConcededAGoalRecAvgArr.get(i);
						sum10 += homeFormRecAvgArr.get(i);

						sum11 += HThomeScoredRecAvgArr.get(i);
						sum12 += HThomeConcededRecAvgArr.get(i);
						sum13 += HToneCountRecAvgArr.get(i);

					}

					FToneCountRecAvg = sum1 / homeForm.size();

					FTtwoCountRecAvg = sum2 / homeForm.size();
					FTthreeCountRecAvg = sum3 / homeForm.size();
					FTfourCountRecAvg = sum4 / homeForm.size();
					FThomeScoredRecAvg = sum6 / homeForm.size();
					FThomeConcededRecAvg = sum7 / homeForm.size();

					homeScoredAGoalRecAvg = sum8 / homeForm.size();
					homeConcededAGoalRecAvg = sum9 / homeForm.size();
					homeFormRecAvg = sum10 / homeForm.size();

					HThomeScoredRecAvg = sum11 / homeForm.size();
					HThomeConcededRecAvg = sum12 / homeForm.size();
					HToneCountRecAvg = sum13 / homeForm.size();

					FThomeOneRecProb = FToneCountRecAvg;

					HThomeOneRecProb = HToneCountRecAvg;
					HThomeScoredRecProb = HThomeScoredRecAvg;
					HThomeConcededRecProb = HThomeConcededRecAvg;
					HThomeOneRegProb = HToneCountRegAvg;
					HThomeScoredRegProb = HThomeScoredRegAvg;
					HThomeConcededRegProb = HThomeConcededRegAvg;

					FThomeTwoRecProb = FTtwoCountRecAvg;
					FThomeThreeRecProb = FTthreeCountRecAvg;
					FThomeFourRecProb = FTfourCountRecAvg;
					FThomeOneRegProb = FToneCountRegAvg;
					FThomeTwoRegProb = FTtwoCountRegAvg;
					FThomeThreeRegProb = FTthreeCountRegAvg;
					FThomeFourRegProb = FTfourCountRegAvg;
					homeFormRegProb = homeFormRegAvg;
					homeFormRecProb = homeFormRecAvg;
					FThomeScoredRegProb = FThomeScoredRegAvg;
					FThomeScoredRecProb = FThomeScoredRecAvg;
					FThomeConcededRegProb = FThomeConcededRegAvg;
					FThomeConcededRecProb = FThomeConcededRecAvg;
					homeScoredAGoalRegProb = homeScoredAGoalRegAvg;
					homeScoredAGoalRecProb = homeScoredAGoalRecAvg;
					homeConcededAGoalRegProb = homeConcededAGoalRegAvg;
					homeConcededAGoalRecProb = homeConcededAGoalRecAvg;

					FToneCount.clear();
					FTtwoCount.clear();
					FTthreeCount.clear();
					FTfourCount.clear();

					HToneCount.clear();

					for (i = 0; i < awayForm.size(); i++) {

						FTawayGoalTemp = FTawayGoals.get(i);
						FTawayOppGoalTemp = FTawayOppGoals.get(i);

						FTawayTotal = FTawayGoalTemp + FTawayOppGoalTemp;

						HTawayGoalTemp = HTawayGoals.get(i);
						HTawayOppGoalTemp = HTawayOppGoals.get(i);

						HTawayTotal = HTawayGoalTemp + HTawayOppGoalTemp;

						if (FTawayGoalTemp > 0)
							awayScoredAGoal.add(1);
						else
							awayScoredAGoal.add(0);

						if (FTawayOppGoalTemp > 0)
							awayConcededAGoal.add(1);
						else
							awayConcededAGoal.add(0);

						if (HTawayTotal == 0) {
							HToneCount.add(0);

						}

						if (HTawayTotal > 0) {
							HToneCount.add(1);

						}

						if (FTawayTotal == 0) {
							FToneCount.add(0);
							FTtwoCount.add(0);
							FTthreeCount.add(0);
							FTfourCount.add(0);
						}

						if (FTawayTotal == 1) {
							FToneCount.add(1);
							FTtwoCount.add(0);
							FTthreeCount.add(0);
							FTfourCount.add(0);
						}

						if (FTawayTotal == 2) {
							FToneCount.add(1);
							FTtwoCount.add(1);
							FTthreeCount.add(0);
							FTfourCount.add(0);
						}

						if (FTawayTotal == 3) {
							FToneCount.add(1);
							FTtwoCount.add(1);
							FTthreeCount.add(1);
							FTfourCount.add(0);
						}

						if (FTawayTotal >= 4) {
							FToneCount.add(1);
							FTtwoCount.add(1);
							FTthreeCount.add(1);
							FTfourCount.add(1);
						}

					}

					sum1 = 0;
					sum2 = 0;
					sum3 = 0;
					sum4 = 0;
					sum5 = 0;
					sum6 = 0;
					sum7 = 0;
					sum8 = 0;
					sum9 = 0;
					sum10 = 0;
					sum11 = 0;
					sum12 = 0;
					sum13 = 0;

					FToneCountRecAvgArr.clear();
					FTtwoCountRecAvgArr.clear();
					FTthreeCountRecAvgArr.clear();
					FTfourCountRecAvgArr.clear();

					HToneCountRecAvgArr.clear();

					for (i = 0; i < awayForm.size(); i++) {

						sum1 += FToneCount.get(i);
						FToneCountRecAvgArr.add(sum1 / (i + 1));

						sum2 += FTtwoCount.get(i);
						FTtwoCountRecAvgArr.add(sum2 / (i + 1));

						sum3 += FTthreeCount.get(i);
						FTthreeCountRecAvgArr.add(sum3 / (i + 1));

						sum4 += FTfourCount.get(i);
						FTfourCountRecAvgArr.add(sum4 / (i + 1));

						sum6 += FTawayGoals.get(i);
						FTawayScoredRecAvgArr.add(sum6 / (i + 1));

						sum7 += FTawayOppGoals.get(i);
						FTawayConcededRecAvgArr.add(sum7 / (i + 1));

						sum8 += awayScoredAGoal.get(i);
						awayScoredAGoalRecAvgArr.add(sum8 / (i + 1));

						sum9 += awayConcededAGoal.get(i);
						awayConcededAGoalRecAvgArr.add(sum9 / (i + 1));

						sum10 += awayForm.get(i);
						awayFormRecAvgArr.add(sum10 / (i + 1));

						sum11 += HTawayGoals.get(i);
						HTawayScoredRecAvgArr.add(sum11 / (i + 1));

						sum12 += HTawayOppGoals.get(i);
						HTawayConcededRecAvgArr.add(sum12 / (i + 1));

						sum13 += HToneCount.get(i);
						HToneCountRecAvgArr.add(sum13 / (i + 1));

					}

					HToneCountRecAvg = 0;
					HToneCountRegAvg = 0;
					HTawayScoredRegAvg = sum11 / awayForm.size();
					HTawayConcededRegAvg = sum12 / awayForm.size();

					FToneCountRecAvg = 0;
					FTtwoCountRecAvg = 0;
					FTthreeCountRecAvg = 0;
					FTfourCountRecAvg = 0;
					FToneCountRegAvg = sum1 / awayForm.size();
					FTtwoCountRegAvg = sum2 / awayForm.size();
					FTthreeCountRegAvg = sum3 / awayForm.size();
					FTfourCountRegAvg = sum4 / awayForm.size();
					FTawayScoredRegAvg = sum6 / awayForm.size();
					FTawayConcededRegAvg = sum7 / awayForm.size();
					awayScoredAGoalRegAvg = sum8 / awayForm.size();
					awayConcededAGoalRegAvg = sum9 / awayForm.size();
					awayFormRegAvg = sum10 / awayForm.size();
					HTawayScoredRegAvg = sum11 / awayForm.size();
					HTawayConcededRegAvg = sum12 / awayForm.size();
					HToneCountRegAvg = sum13 / HToneCount.size();

					sum1 = 0;
					sum2 = 0;
					sum3 = 0;
					sum4 = 0;
					sum5 = 0;
					sum6 = 0;
					sum7 = 0;
					sum8 = 0;
					sum9 = 0;
					sum10 = 0;
					sum11 = 0;
					sum12 = 0;
					sum13 = 0;

					for (i = 0; i < awayForm.size(); i++) {

						sum1 += FToneCountRecAvgArr.get(i);

						sum2 += FTtwoCountRecAvgArr.get(i);
						sum3 += FTthreeCountRecAvgArr.get(i);
						sum4 += FTfourCountRecAvgArr.get(i);
						sum6 += FTawayScoredRecAvgArr.get(i);
						sum7 += FTawayConcededRecAvgArr.get(i);
						sum8 += awayScoredAGoalRecAvgArr.get(i);
						sum9 += awayConcededAGoalRecAvgArr.get(i);
						sum10 += awayFormRecAvgArr.get(i);

						sum11 += HTawayScoredRecAvgArr.get(i);
						sum12 += HTawayConcededRecAvgArr.get(i);
						sum13 += HToneCountRecAvgArr.get(i);

					}

					FToneCountRecAvg = sum1 / awayForm.size();

					FTtwoCountRecAvg = sum2 / awayForm.size();
					FTthreeCountRecAvg = sum3 / awayForm.size();
					FTfourCountRecAvg = sum4 / awayForm.size();
					FTawayScoredRecAvg = sum6 / awayForm.size();
					FTawayConcededRecAvg = sum7 / awayForm.size();
					awayScoredAGoalRecAvg = sum8 / awayForm.size();
					awayConcededAGoalRecAvg = sum9 / awayForm.size();
					awayFormRecAvg = sum10 / awayForm.size();

					HTawayScoredRecAvg = sum11 / awayForm.size();
					HTawayConcededRecAvg = sum12 / awayForm.size();
					HToneCountRecAvg = sum13 / awayForm.size();

					FTawayOneRecProb = FToneCountRecAvg;

					HTawayOneRecProb = HToneCountRecAvg;
					HTawayScoredRecProb = HTawayScoredRecAvg;
					HTawayConcededRecProb = HTawayConcededRecAvg;
					HTawayOneRegProb = HToneCountRegAvg;
					HTawayScoredRegProb = HTawayScoredRegAvg;
					HTawayConcededRegProb = HTawayConcededRegAvg;

					FTawayTwoRecProb = FTtwoCountRecAvg;
					FTawayThreeRecProb = FTthreeCountRecAvg;
					FTawayFourRecProb = FTfourCountRecAvg;
					FTawayOneRegProb = FToneCountRegAvg;
					FTawayTwoRegProb = FTtwoCountRegAvg;
					FTawayThreeRegProb = FTthreeCountRegAvg;
					FTawayFourRegProb = FTfourCountRegAvg;
					awayFormRegProb = awayFormRegAvg;
					awayFormRecProb = awayFormRecAvg;
					FTawayScoredRegProb = FTawayScoredRegAvg;
					FTawayScoredRecProb = FTawayScoredRecAvg;
					FTawayConcededRegProb = FTawayConcededRegAvg;
					FTawayConcededRecProb = FTawayConcededRecAvg;

					awayScoredAGoalRegProb = awayScoredAGoalRegAvg;
					awayScoredAGoalRecProb = awayScoredAGoalRecAvg;
					awayConcededAGoalRegProb = awayConcededAGoalRegAvg;
					awayConcededAGoalRecProb = awayConcededAGoalRecAvg;

//					FThomeExpectedRecProb = (FThomeScoredRecProb + FTawayConcededRecProb) / 2;
//					FTawayExpectedRecProb = (FTawayScoredRecProb + FThomeConcededRecProb) / 2;
//
//
//					HThomeExpectedRecProb = (HThomeScoredRecProb + HTawayConcededRecProb) / 2;
//					HTawayExpectedRecProb = (HTawayScoredRecProb + HThomeConcededRecProb) / 2;
//					HTtotalExpectedRecProb = HThomeExpectedRecProb + HTawayExpectedRecProb;

					if (neutral) {

						neutralHomeFormRecProb = homeFormRecProb;
						neutralAwayFormRecProb = awayFormRecProb;
						FTneutralHomeScoredRecProb = FThomeScoredRecProb;
						FTneutralAwayScoredRecProb = FTawayScoredRecProb;
						FTneutralHomeConcededRecProb = FThomeConcededRecProb;
						FTneutralAwayConcededRecProb = FTawayScoredRecProb;
						FTneutralHomeExpectedRecProb = FThomeExpectedRecProb;
						FTneutralAwayExpectedRecProb = FTawayExpectedRecProb;
						FTneutralHomeOneRecProb = FThomeOneRecProb;
						FTneutralHomeTwoRecProb = FThomeTwoRecProb;
						FTneutralHomeThreeRecProb = FThomeThreeRecProb;
						FTneutralHomeFourRecProb = FThomeFourRecProb;
						FTneutralAwayOneRecProb = FTawayOneRecProb;
						FTneutralAwayTwoRecProb = FTawayTwoRecProb;
						FTneutralAwayThreeRecProb = FTawayThreeRecProb;
						FTneutralAwayFourRecProb = FTawayFourRecProb;

						neutralHomeFormRegProb = homeFormRegProb;
						neutralAwayFormRegProb = awayFormRegProb;
						FTneutralHomeScoredRegProb = FThomeScoredRegProb;
						FTneutralAwayScoredRegProb = FTawayScoredRegProb;
						FTneutralHomeConcededRegProb = FThomeConcededRegProb;
						FTneutralAwayConcededRegProb = FTawayScoredRegProb;
						FTneutralHomeExpectedRegProb = FThomeExpectedRegProb;
						FTneutralAwayExpectedRegProb = FTawayExpectedRegProb;
						FTneutralHomeOneRegProb = FThomeOneRegProb;
						FTneutralHomeTwoRegProb = FThomeTwoRegProb;
						FTneutralHomeThreeRegProb = FThomeThreeRegProb;
						FTneutralHomeFourRegProb = FThomeFourRegProb;
						FTneutralAwayOneRegProb = FTawayOneRegProb;
						FTneutralAwayTwoRegProb = FTawayTwoRegProb;
						FTneutralAwayThreeRegProb = FTawayThreeRegProb;
						FTneutralAwayFourRegProb = FTawayFourRegProb;


						neutralHomeScoredAGoalExpectedRecProb = homeScoredAGoalRecProb;
						neutralAwayScoredAGoalExpectedRecProb = awayScoredAGoalRecProb;
						neutralHomeConcededAGoalExpectedRecProb = homeConcededAGoalRecProb;
						neutralAwayConcededAGoalExpectedRecProb = awayConcededAGoalRecProb;

						neutralHomeScoredAGoalExpectedRegProb = homeScoredAGoalRegProb;
						neutralAwayScoredAGoalExpectedRegProb = awayScoredAGoalRegProb;
						neutralHomeConcededAGoalExpectedRegProb = homeConcededAGoalRegProb;
						neutralAwayConcededAGoalExpectedRegProb = awayConcededAGoalRegProb;

						FTneutralHomeGoals.addAll(FThomeGoals);
						FTneutralAwayGoals.addAll(FTawayGoals);
						FTneutralHomeOppGoals.addAll(FThomeOppGoals);
						FTneutralAwayOppGoals.addAll(FTawayOppGoals);
						neutralHomeForm.addAll(homeForm);
						neutralAwayForm.addAll(awayForm);

						HTneutralHomeScoredRecProb = HThomeScoredRecProb;
						HTneutralAwayScoredRecProb = HTawayScoredRecProb;
						HTneutralHomeConcededRecProb = HThomeConcededRecProb;
						HTneutralAwayConcededRecProb = HTawayConcededRecProb;

						HTneutralHomeExpectedRecProb = HThomeExpectedRecProb;
						HTneutralAwayExpectedRecProb = HTawayExpectedRecProb;

						HTneutralHomeOneRecProb = HThomeOneRecProb;
						HTneutralAwayOneRecProb = HTawayOneRecProb;

						HTneutralHomeScoredRegProb = HThomeScoredRegProb;
						HTneutralAwayScoredRegProb = HTawayScoredRegProb;
						HTneutralHomeConcededRegProb = HThomeConcededRegProb;
						HTneutralAwayConcededRegProb = HTawayConcededRegProb;

						HTneutralHomeExpectedRegProb = HThomeExpectedRegProb;
						HTneutralAwayExpectedRegProb = HTawayExpectedRegProb;

						HTneutralHomeOneRegProb = HThomeOneRegProb;
						HTneutralAwayOneRegProb = HTawayOneRegProb;

						HTneutralHomeGoals.addAll(HThomeGoals);
						HTneutralAwayGoals.addAll(HTawayGoals);

					}

					neutral = false;

				} // h/a for loop

				if (neutralHomeForm.size() < 20 || neutralAwayForm.size() < 20)
					continue;
				double oddsBetThis = 0;
				double systemBetThis = 0;

				
				
				
				// get odds
				// click odds tab
				
				// driver.findElement(By.xpath("//*[@id=\"match\"]/nav/div[3]/a")).click();
				// // click 1x2 tab
				// driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a[1]")).click();
				// String homeMaxOddsS = "";
				// String awayMaxOddsS = "";

				// if (oddsOption.equals("Pre")) {
				// 	// grab home odds (min)
				// 	homeMaxOddsS = driver.findElement(By.xpath("//*[@id=\"oContent\"]/table/tbody/tr[5]/td[2]"))
				// 			.getText();

				// 	// grab away odds (min)
				// 	awayMaxOddsS = driver.findElement(By.xpath("//*[@id=\"oContent\"]/table/tbody/tr[5]/td[4]"))
				// 			.getText();
				// } else if (oddsOption.equals("Live")) {

				// 	homeMaxOddsS = driver.findElement(By.xpath("//*[@id=\"oContent\"]/table/tbody/tr[3]/td[5]"))
				// 			.getText();

				// 	// grab away odds (min)
				// 	awayMaxOddsS = driver.findElement(By.xpath("//*[@id=\"oContent\"]/table/tbody/tr[3]/td[7]"))
				// 			.getText();
				// }

				// float homeOdds = Float.parseFloat(homeMaxOddsS);
				// float awayOdds = Float.parseFloat(awayMaxOddsS);
//				float homeOdds = Float.parseFloat(homePreOddsS);
//				float awayOdds = Float.parseFloat(awayPreOddsS);

//				float homeAvgMaxOdds = ls.avg(homeAvgOdds, homeMaxOdds);
//				float awayAvgMaxOdds = ls.avg(awayAvgOdds, awayMaxOdds);

				// float oddsDiff = Math.abs(homeOdds - awayOdds);
				// float minMinOdds = Math.min(homeMinOdds, awayMinOdds);
				// float avgOdds = Math.min(homeAvgOdds, awayAvgOdds);
				
//				System.out.println("homeScoredAGoalRecProb = " + homeScoredAGoalRecProb);
//				System.out.println("homeConcededAGoalRecProb = " + homeConcededAGoalRecProb);
//				System.out.println("awayScoredAGoalRecProb = " + awayScoredAGoalRecProb);
//				System.out.println("awayConcededAGoalRecProb = " + awayConcededAGoalRecProb);
//				System.out.println("neutralHomeScoredAGoalExpectedRecProb = " + neutralHomeScoredAGoalExpectedRecProb);
//				System.out.println("neutralHomeConcededAGoalExpectedRecProb = " + neutralHomeConcededAGoalExpectedRecProb);
//				System.out.println("neutralAwayScoredAGoalExpectedRecProb = " + neutralAwayScoredAGoalExpectedRecProb);
//				System.out.println("neutralAwayConcededAGoalExpectedRecProb = " + neutralAwayConcededAGoalExpectedRecProb);
//				

				float FTtotalHomeRecForm = ls.avg(neutralHomeFormRecProb, homeFormRecProb);
				float FTtotalAwayRecForm = ls.avg(neutralAwayFormRecProb, awayFormRecProb);
				float FTMinRecForm = Math.min(FTtotalHomeRecForm, FTtotalAwayRecForm);
				float FTMaxRecForm = Math.max(FTtotalHomeRecForm, FTtotalAwayRecForm);
				float formDiffRec = (FTtotalHomeRecForm - FTtotalAwayRecForm);
				float FTtotalHomeScoredRecProb = ls.avg(FTneutralHomeScoredRecProb, FThomeScoredRecProb);
				float FTtotalAwayScoredRecProb = ls.avg(FTneutralAwayScoredRecProb, FTawayScoredRecProb);
				float FTtotalScoredRecProb = FTtotalHomeScoredRecProb + FTtotalAwayScoredRecProb;
				float FTtotalHomeConcededRecProb = ls.avg(FTneutralHomeConcededRecProb, FThomeConcededRecProb);
				float FTtotalAwayConcededRecProb = ls.avg(FTneutralAwayConcededRecProb, FTawayConcededRecProb);
				float FTtotalConcededRecProb = FTtotalHomeConcededRecProb + FTtotalAwayConcededRecProb;
				float FTtotalHomeExpectedRecProb = ls.avg(FTtotalHomeScoredRecProb, FTtotalAwayConcededRecProb);
				float FTtotalAwayExpectedRecProb = ls.avg(FTtotalAwayScoredRecProb, FTtotalHomeConcededRecProb);
				float FTtotalMinHomeExpectedRecProb = Math.min(FTtotalHomeScoredRecProb, FTtotalAwayConcededRecProb);
				float FTtotalMinAwayExpectedRecProb = Math.min(FTtotalAwayScoredRecProb, FTtotalHomeConcededRecProb);
				
				float FTmaxMinExpectedRecProb = Math.max(FTtotalMinHomeExpectedRecProb, FTtotalMinAwayExpectedRecProb);

				float FTtotalMinExpectedRecProb = FTtotalMinHomeExpectedRecProb + FTtotalMinAwayExpectedRecProb;
				FTtotalExpectedRecProb = FTtotalHomeExpectedRecProb + FTtotalAwayExpectedRecProb;
				float FTMaxExpectedRecProb = Math.max(FTtotalHomeExpectedRecProb, FTtotalAwayExpectedRecProb);
				float totalHomeScoredAGoalExpectedRecProb = ls.avg(neutralHomeScoredAGoalExpectedRecProb,
						homeScoredAGoalRecProb);
				float totalAwayScoredAGoalExpectedRecProb = ls.avg(neutralAwayScoredAGoalExpectedRecProb,
						awayScoredAGoalRecProb);
				float totalHomeConcededAGoalExpectedRecProb = ls.avg(neutralHomeConcededAGoalExpectedRecProb,
						homeConcededAGoalRecProb);
				float totalAwayConcededAGoalExpectedRecProb = ls.avg(neutralAwayConcededAGoalExpectedRecProb,
						awayConcededAGoalRecProb);
				float homeGolX = Math.min(totalHomeScoredAGoalExpectedRecProb, totalAwayConcededAGoalExpectedRecProb);
				float awayGolX = Math.min(totalAwayScoredAGoalExpectedRecProb, totalHomeConcededAGoalExpectedRecProb);
				float minGolX = Math.min(homeGolX, awayGolX);
				float maxGolX = Math.max(homeGolX, awayGolX);

				float maxScoredAGoal = Math.max(totalHomeScoredAGoalExpectedRecProb,
						totalAwayScoredAGoalExpectedRecProb);
				float maxConcededAGoal = Math.max(totalHomeConcededAGoalExpectedRecProb,
						totalAwayConcededAGoalExpectedRecProb);
				float FTtotalHomeOneRecProb = ls.avg(FTneutralHomeOneRecProb, FThomeOneRecProb);
				float FTtotalHomeTwoRecProb = ls.avg(FTneutralHomeTwoRecProb, FThomeTwoRecProb);
				float FTtotalHomeThreeRecProb = ls.avg(FTneutralHomeThreeRecProb, FThomeThreeRecProb);
				float FTtotalHomeFourRecProb = ls.avg(FTneutralHomeFourRecProb, FThomeFourRecProb);
				float FTtotalAwayOneRecProb = ls.avg(FTneutralAwayOneRecProb, FTawayOneRecProb);
				float FTtotalAwayTwoRecProb = ls.avg(FTneutralAwayTwoRecProb, FTawayTwoRecProb);
				float FTtotalAwayThreeRecProb = ls.avg(FTneutralAwayThreeRecProb, FTawayThreeRecProb);
				float FTtotalAwayFourRecProb = ls.avg(FTneutralAwayFourRecProb, FTawayFourRecProb);
				float HTtotalHomeOneRecProb = ls.avg(HTneutralHomeOneRecProb, HThomeOneRecProb);
				float HTtotalAwayOneRecProb = ls.avg(HTneutralAwayOneRecProb, HTawayOneRecProb);
				float HTMinRecOne = Math.min(HTtotalHomeOneRecProb, HTtotalAwayOneRecProb);

				float FTMinRecOne = Math.min(FTtotalHomeOneRecProb, FTtotalAwayOneRecProb);
				float FTMinRecTwo = Math.min(FTtotalHomeTwoRecProb, FTtotalAwayTwoRecProb);
				float FTMinRecThree = Math.min(FTtotalHomeThreeRecProb, FTtotalAwayThreeRecProb);
				float FTMinRecFour = Math.min(FTtotalHomeFourRecProb, FTtotalAwayFourRecProb);
				float FTMaxRecOne = Math.max(FTtotalHomeOneRecProb, FTtotalAwayOneRecProb);
				float FTMaxRecTwo = Math.max(FTtotalHomeTwoRecProb, FTtotalAwayTwoRecProb);
				float FTMaxRecThree = Math.max(FTtotalHomeThreeRecProb, FTtotalAwayThreeRecProb);
				float FTMaxRecFour = Math.max(FTtotalHomeFourRecProb, FTtotalAwayFourRecProb);
				float FTAvgRecOne = ls.avg(FTtotalHomeOneRecProb, FTtotalAwayOneRecProb);
				float FTAvgRecTwo = ls.avg(FTtotalHomeTwoRecProb, FTtotalAwayTwoRecProb);
				float FTAvgRecThree = ls.avg(FTtotalHomeThreeRecProb, FTtotalAwayThreeRecProb);
				float FTAvgRecFour = ls.avg(FTtotalHomeFourRecProb, FTtotalAwayFourRecProb);

				// float minMaxOdds = Math.min(homeOdds, awayOdds);
				// float homeFormOdds = FTtotalHomeRecForm / homeOdds;
				// float awayFormOdds = FTtotalAwayRecForm / awayOdds;
				// float formOddsDiff = homeFormOdds - awayFormOdds;
				// float minFormOdds = Math.min(homeFormOdds, awayFormOdds);
				// float maxFormOdds = Math.max(homeFormOdds, awayFormOdds);
				// float oddsDiff = homeOdds - awayOdds;

				// float homeFormOddsIndex = (((3/homeOdds) + FTtotalHomeRecForm)/2) ;
				// float awayFormOddsIndex = (((3/awayOdds) + FTtotalAwayRecForm)/2) ;
				// float formOddsIndex = homeFormOddsIndex - awayFormOddsIndex;
				
								

				
				if ( (Float.compare(FTMinRecOne, (float) 0.9) >= 0))
					oddsBetThis++;	
				if ( (Float.compare(FTMinRecTwo, (float) 0.85) >= 0))
					oddsBetThis++;
				if ( (Float.compare(FTMinRecThree, (float) 0.8) >= 0) )
					oddsBetThis++;
				if ( (Float.compare(FTMinRecFour, (float) 0.75) >= 0) )
					oddsBetThis++;

		
				oddsBetThis = oddsBetThis - 0.5;

				if ( (Float.compare(maxGolX, (float) 0.8) < 0) )
				oddsBetThis = -0.5;

				if ((Float.compare(formDiffRec, (float) 0) < 0) && (Float.compare(formDiffRec, (float) -1.5) > 0) )
				oddsBetThis--;

				if(
					
				!tier.equals("E") && !tier.equals("D")  && oddsBetThis > 0 &&
				(Float.compare(formDiffRec, (float) 1.1) >= 0) 
				&& 
				(Float.compare(FTtotalAwayRecForm, (float) 1.1) < 0)
				&& 
				(Float.compare(FTtotalHomeRecForm, (float) 1.7) >= 0))
				betType = "1X";

				if(!tier.equals("E") && !tier.equals("D") &&
				(Float.compare(formDiffRec, (float) 1.1) >= 0) 
				&& 
				(Float.compare(FTtotalAwayRecForm, (float) 1.1) < 0)
				&& 
				(Float.compare(FTtotalHomeRecForm, (float) 1.7) >= 0))
				betType += " AWAY UNDER 2.5";



				
				if(!tier.equals("E") &&
				  !neutralHomeForm.get(0).equals(0) &&  (Float.compare(formDiffRec, (float) 1) >  0) &&  (Float.compare(HTMinRecOne, (float) 0.8) >=  0)  && (Float.compare(FTMinRecForm, (float) 1.5) <  0)  && (Float.compare(FTMaxRecForm, (float) 1.5) >=  0) && (Float.compare(FTtotalMinExpectedRecProb, (float) 2.3) >=  0) )
					betType += " 1HG";

					if(  oddsBetThis > 0 && (Float.compare(formDiffRec, (float) 1.2) < 0))
					betType += " NO SIDES";
					else if ( oddsBetThis > 0 && (Float.compare(formDiffRec, (float) 1.2) >= 0))
					betType += " SIDES";

					if((Float.compare(FTMaxRecForm, (float) 1.4) < 0))
					continue;

					if(  oddsBetThis < 0 && betType.equals(("")))
					continue;


if(
				true

				) {
					myWriter.write(date + " " + time);
					myWriter.write(",");
					myWriter.write(homeName + " - " + FTtotalHomeRecForm + " / "
							+ FTtotalMinHomeExpectedRecProb);
					myWriter.write(",");
					myWriter.write(awayName + " - " + FTtotalAwayRecForm + " / "
							+ FTtotalMinAwayExpectedRecProb);
					myWriter.write(",");
					 myWriter.write(Double.toString(formDiffRec));
					 myWriter.write(",");
					myWriter.write(Double.toString(oddsBetThis));
					myWriter.write(",");
					myWriter.write(betType);
					myWriter.write(",");
					myWriter.write(league2);
					myWriter.write(",");
					myWriter.write(tier);
					myWriter.write(",");
					myWriter.write(link);
					myWriter.write(",");
					myWriter.write("links.add(\"" + link + "\");");

					myWriter.write(System.lineSeparator()); // new line

					System.out.println();

					// System.out.println(link);
					System.out.println(date + " " + time);
					try {
						System.out.format("|%-25s|", league2.substring(0, 24));
					} catch (Exception e) {
						System.out.format("|%-25s|", league2);
					}
					System.out.format("|%-25s|", homeName);
					System.out.format("|%-25s|", awayName);
					System.out.format("|%-25s|", "");
					System.out.println();
					System.out.format("|%-25s|", "Form Rec");
					System.out.format("|%-25s|", Float.toString(FTtotalHomeRecForm).substring(0, 3) );
					System.out.format("|%-25s|", Float.toString(FTtotalAwayRecForm).substring(0, 3) );
					System.out.format("|%-25s|", formDiffRec);
					System.out.println();
					// System.out.format("|%-25s|", "formOddsIndex");
					// System.out.format("|%-25s|", homeFormOddsIndex);
					// System.out.format("|%-25s|", awayFormOddsIndex);
					// System.out.format("|%-25s|", formOddsIndex);
					// System.out.println();
					System.out.format("|%-25s|", "FT Rec Expected Score");
					System.out.format("|%-25s|", Float.toString(FTtotalMinHomeExpectedRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTtotalMinAwayExpectedRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTtotalMinExpectedRecProb).substring(0, 3));
					System.out.println();
					System.out.format("|%-25s|", "FT Rec Score Probablility");
					System.out.format("|%-25s|", Float.toString(homeGolX).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(awayGolX).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(minGolX).substring(0, 3));
					System.out.println();
					System.out.format("|%-25s|", "oddsBetThis -> " + oddsBetThis);
					System.out.format("|%-25s|", "betType -> " + betType);
					System.out.format("|%-25s|", "tier -> " + tier);
					System.out.println();
					System.out.format("|%-25s|", "FT Goals");
					System.out.format("|%-25s|", FThomeScore);
					System.out.format("|%-25s|", FTawayScore);
					System.out.format("|%-25s|", FTScore);
					System.out.println();
					System.out.format("|%-25s|", "HT Goals");
					System.out.format("|%-25s|", HThomeScore);
					System.out.format("|%-25s|", HTawayScore);
					System.out.format("|%-25s|", HTScore);
					System.out.println();
					System.out.format("|%-25s|", "HT One Prob");
					System.out.format("|%-25s|", Float.toString(HTtotalHomeOneRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(HTtotalAwayOneRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(HTMinRecOne).substring(0, 4));
					System.out.println();
					System.out.format("|%-25s|", "FT One Prob");
					System.out.format("|%-25s|", Float.toString(FTtotalHomeOneRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTtotalAwayOneRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTMinRecOne).substring(0, 3));
					System.out.println();
					System.out.format("|%-25s|", "FT Two Prob");
					System.out.format("|%-25s|", Float.toString(FTtotalHomeTwoRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTtotalAwayTwoRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTMinRecTwo).substring(0, 3));
					System.out.println();
					System.out.format("|%-25s|", "FT Three Prob");
					System.out.format("|%-25s|", Float.toString(FTtotalHomeThreeRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTtotalAwayThreeRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTMinRecThree).substring(0, 3));
					System.out.println();
					System.out.format("|%-25s|", "FT Four Prob");
					System.out.format("|%-25s|", Float.toString(FTtotalHomeFourRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTtotalAwayFourRecProb).substring(0, 3));
					System.out.format("|%-25s|", Float.toString(FTMinRecFour).substring(0, 3));

					System.out.println();

				} else
					continue;

			} catch (Exception e) {
				// System.out.println(e);

				// myWriter.close();
				//
				// driver.close();
				// driver.quit();

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

	public ArrayList<String> fixtureGrab(WebDriver driver, int i, int h, ArrayList<String> links, WebDriverWait wait,
			int startIndex, int endIndex, String day, String betType) {
		if (betType.equals("Live")) {
			driver.get("https://www.goaloo.mobi/football/");
		} else if (betType.equals("Schedule")) {
			driver.get("https://www.goaloo.mobi/football/schedule-" + day + "");
			driver.findElement(By.xpath("//*[@id='fHead']/div[1]/span[2]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='displayZone']")));
			driver.findElement(By.xpath("//*[@id='displayZone']")).click();
			driver.findElement(By.xpath("//*[@id='setting_popSel']/ul/li[8]")).click();
			driver.navigate().refresh();
		}

		// driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='hideCountBar']/span[2]")));
		driver.findElement(By.xpath("//*[@id='hideCountBar']/span[2]")).click();

		i = startIndex;

		while (true && i < endIndex) {
			try {

				h = i + 1;
				String postponedCanceledFT;
				String league;

				// postponedCanceledFT =
				// driver.findElement(By.xpath("//*[@id='gameList']/div["+h+"]/div[3]/i")).getText();
				// league =
				// driver.findElement(By.xpath("//*[@id='gameList']/div["+h+"]/div[2]/div[1]/span[2]")).getText();
				//
				//// // System.out.println(postponedCanceledFT);
				////// if (postponedCanceledFT.equals("Postp.") ||
				// postponedCanceledFT.equals("Canceled")) {
				////// i++;
				////// continue;
				////
				// if (
				// league.contains("Youth") ||
				// league.contains("RUS YthC") ||
				// league.contains("U17") ||
				// league.contains("U18") ||
				// league.contains("U19") ||
				// league.contains("U20") ||
				// league.contains("Finland K")
				//
				//
				//
				// )
				// {
				// i++;
				// continue;
				// }
				// else {

				String fixture = driver.findElement(By.xpath("//*[@id='gameList']/div[" + h + "]")).getAttribute("id");

				if (fixture.contains("ad")) {
					i++;
					continue;
				}

				if (fixture.equals("")) {
					i++;
					continue;
				}

				// System.out.println("fixture = " + fixture);

				String[] fixtureSplit = fixture.split("_");

				links.add("https://www.goaloo.mobi/football/match/h2h-" + fixtureSplit[1]);

				i++;
				// }
			} catch (Exception e) {
				// System.out.println(e);
				System.out.println("# links = " + links.size());
				break;
			}
		}

		return links;

	}

	public ArrayList<String> scheduleGrab(WebDriver driver, int i, int h, ArrayList<String> links, String schedule,
			int week) {

		// driver.get("http://www.goaloo.mobi/football/database/schedule-" + schedule +
		// "?round=" + week);

		driver.get("https://www.goaloo.site/football/database/schedule-135?round=17");

		while (true) {

			try {

				h = i + 1;

				String scheduleTb = driver.findElement(By.xpath("//*[@id='scheduleTb']/tbody/tr[" + h + "]"))
						.getAttribute("href");
				String scheduleSplit = scheduleTb.replace("detail", "analysis");

				//
				// System.out.println("scheduleSplit[0] = " + scheduleSplit[0]);
				// System.out.println("scheduleSplit[1] = " + scheduleSplit[1]);

				if (scheduleTb.equals(null))
					i++;
				else
					links.add("https://www.goaloo.mobi" + scheduleSplit);
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
	// end class

	public float avg(float one, float two) {

		return (one + two) / 2;
	}
}