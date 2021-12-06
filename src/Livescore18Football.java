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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Livescore18Football {

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub

        // setting the driver executable
//		System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
//		EdgeOptions options = new EdgeOptions();
//
//		WebDriver driver = new EdgeDriver();

        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 1);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

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

        // String mode = "H/A Same"
        String games = "10";
        boolean sameLeague = false;
        int startIndex = 1;
        int endIndex = 50;
        String day = "n0";
        System.out.println("In League = " + sameLeague);
        System.out.println("startIndex = " + startIndex);
        System.out.println("endIndex = " + endIndex);

        Livescore18Football ls = new Livescore18Football();


////		links = ls.scheduleGrab(driver,i,h,links, "816",16);
//links = ls.fixtureGrab(driver, i, h, links, wait, startIndex,  endIndex, day);
//	links = ls.fixtureGrab(driver, i, h, links, wait, 1, 710, "n1");
//	links = ls.fixtureGrab(driver, i, h, links, wait, 200, 300, "n1");
//	links = ls.fixtureGrab(driver, i, h, links, wait, 300, 400, "n1");

//////     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[500]")));

      links.add("https://www.goaloo.mobi/football/match/h2h-2081993");
   //   links.add("https://www.goaloo.mobi/football/match/h2h-2043975");
//      links.add("https://www.goaloo.mobi/football/match/h2h-2064006");
//         links.add("https://www.goaloo.mobi/football/match/h2h-2126014");
//         links.add("https://www.goaloo.mobi/football/match/h2h-2086418");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2030532");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2037131");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2056464");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2125782");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2053462");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2048235");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2027920");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2091251");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2051514");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2126128");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2113385");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2126371");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2121967");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2106477");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2037628");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2056409");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2115345");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2029447");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2042808");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2115112");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2039941");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2050759");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2113307");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2113298");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2021769");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2115242");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2003788");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2065516");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2025255");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2008246");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2026311");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2031032");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2067882");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2055750");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2109875");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2008241");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2053219");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2057810");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1998934");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2008229");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2090076");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2090077");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2108256");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2086179");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2108541");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2078631");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1988003");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2078634");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2086171");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2109386");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2056399");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2077929");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2025937");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2007980");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2086239");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2008212");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2008213");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2025255");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2021728");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2107618");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2021927");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2024682");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2041195");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2036481");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2075622");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2081155");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1970682");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2003477");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2028637");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2005189");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2031511");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2052278");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2068216");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2036165");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2100344");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2090071");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1985288");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1995070");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2016645");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2053385");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2029960");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2059730");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2055741");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2106095");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2027538");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2046567");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2033205");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2028635");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1998903");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1998909");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2092056");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2046108");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2100338");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2093692");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1969554");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1970010");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2008187");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1983897");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2073168");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2048007");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1908158");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1915438");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2027776");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2035990");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2059726");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2068757");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1983894");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1970675");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2046127");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2104240");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2059728");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2036481");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1988727");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2092119");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2105080");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2056994");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2003469");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1995073");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2043036");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1983891");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2104896");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2102709");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2043042");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2074187");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2092055");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2092092");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2092156");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2092191");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1968928");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2093162");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2029958");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2059725");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2097182");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2054943");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2068078");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2069269");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2055153");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2042779");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2045580");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2104945");
//		links.add("https://www.goaloo.mobi/football/match/h2h-1952307");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2050722");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2041188");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2032760");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2046122");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2105433");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2053201");
//		links.add("https://www.goaloo.mobi/football/match/h2h-2043814");

//		// Using list iterator
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
            ArrayList<Integer> HTneutralHomeOppGoals = new ArrayList<Integer>();
            ArrayList<Integer> HTneutralAwayGoals = new ArrayList<Integer>();
            ArrayList<Integer> HTneutralAwayOppGoals = new ArrayList<Integer>();


            float FThomeExpectedRecProb = 0, FTawayExpectedRecProb = 0, FThomeScoredRecProb = 0,
                    FTawayScoredRecProb = 0, FThomeConcededRecProb = 0, FTawayConcededRecProb = 0,
                    FTtotalExpectedProb = 0, FTtotalExpectedRecProb = 0, HThomeExpectedRecProb = 0,
                    HTawayExpectedRecProb = 0, HThomeScoredRecProb = 0, HTawayScoredRecProb = 0,
                    HThomeConcededRecProb = 0, HTawayConcededRecProb = 0, HTtotalExpectedProb = 0,
                    HTtotalExpectedRecProb = 0, homeScoredAGoalExpectedRecProb = 0, awayScoredAGoalExpectedRecProb = 0,

                    homeFormRecProb = 0, awayFormRecProb = 0, formDiffRec = 0, maxForm = 0, FTmaxOne = 0, HTmaxOne = 0,
                    maxTwo = 0, maxThree = 0, maxFour = 0, FThomeOneRecProb = 0, homeTwoRecProb = 0,
                    homeThreeRecProb = 0, homeFourRecProb = 0, FTawayOneRecProb = 0, HThomeOneRecProb = 0,
                    HTawayOneRecProb = 0, awayTwoRecProb = 0, awayThreeRecProb = 0, awayFourRecProb = 0,
                    FTneutralHomeOneRecProb = 0, HTneutralHomeOneRecProb = 0, neutralHomeTwoRecProb = 0,
                    neutralHomeThreeRecProb = 0, neutralHomeFourRecProb = 0, FTneutralAwayOneRecProb = 0,
                    HTneutralAwayOneRecProb = 0, neutralAwayTwoRecProb = 0, neutralAwayThreeRecProb = 0,
                    neutralAwayFourRecProb = 0, neutralHomeFormRecProb = 0, neutralAwayFormRecProb = 0,
                    FTneutralHomeExpectedRecProb = 0, FTneutralAwayExpectedRecProb = 0, FTneutralHomeScoredRecProb = 0,
                    FTneutralAwayScoredRecProb = 0, FTneutralHomeConcededRecProb = 0, FTneutralAwayConcededRecProb = 0,
                    neutralHomeScoredAGoalExpectedRecProb = 0, neutralAwayScoredAGoalExpectedRecProb = 0,
                    FTneutralTotalExpectedProb = 0, FTneutralTotalExpectedRecProb = 0, HTneutralHomeExpectedRecProb = 0,
                    HTneutralAwayExpectedRecProb = 0, HTneutralHomeScoredRecProb = 0, HTneutralAwayScoredRecProb = 0,
                    HTneutralHomeConcededRecProb = 0, HTneutralAwayConcededRecProb = 0, HTneutralTotalExpectedProb = 0,
                    HTneutralTotalExpectedRecProb = 0, neturalFormDiffRec = 0, neutralMaxForm = 0, FTneutralMaxOne = 0,
                    HTneutralMaxOne = 0, neutralMaxTwo = 0, neutralMaxThree = 0, neutralMaxFour = 0;

            String homeName, awayName, homeTeamName, date, time = null, matchResult, matchType, matchTitle, matchDay,
                    matchScore = "";
            int FThomeGoalTemp, FThomeOppGoalTemp, FTawayGoalTemp, FTawayOppGoalTemp, FThomeTotal, FTawayTotal,
                    HThomeGoalTemp, HThomeOppGoalTemp, HTawayGoalTemp, HTawayOppGoalTemp, HThomeTotal, HTawayTotal,
                    FThomeScore = 0, FTawayScore = 0, FTScore, HTScore, HThomeScore = 0, HTawayScore = 0;
            LocalDate todayDate = null;
            int days = 0;

            String league2;
            int leagueGameHome = 0, leagueGameAway = 0;
            boolean leagueGame = false;

            try {

                FThomeScore = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"liveHS\"]")).getText());
                // System.out.println("homeScore = " + scores[0]);

                FTawayScore = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"liveGS\"]")).getText());
                // System.out.println("awayScore = " + scores[1]);

                // *[@id="liveHt"]
                String StringHTScore = driver.findElement(By.xpath("//*[@id=\"liveHt\"]")).getText();
                // System.out.println("homeScore = " + scores[0]);

//			System.out.println("HTScore[0] = " + StringHTScore.split(" - ")[0].replace("(", ""));
//			System.out.println("HTScore[1] = " + StringHTScore.split(" - ")[1].replace(")", ""));

                HThomeScore = Integer.parseInt(StringHTScore.split(" - ")[0].replace("(", ""));

                HTawayScore = Integer.parseInt(StringHTScore.split(" - ")[1].replace(")", ""));

            } catch (Exception e) {
            }

            FTScore = FThomeScore + FTawayScore;
            HTScore = HThomeScore + HTawayScore;

            try {

                // get matchTitle
                league2 = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[1]/div[1]/a")).getText();

                System.out.println("matchTitle = " + league2);

//================== LEAGUE BLACKLIST ======================================================

//				if(league2.contains("Kolmonen") || league2.contains("Turkey 3."))
//					continue;

                try {
                    // get time of game
                    date = driver.findElement(By.xpath("//*[@id='liveMt']")).getText();

                    String[] dateSplit = date.split(" ");
                    date = dateSplit[0];
                    time = dateSplit[1];
                    todayDate = LocalDate.parse(date.substring(0, 10), formatter2);
                } catch (Exception e) {
                    date = driver.findElement(By.xpath("//*[@id='liveSt']")).getText();
                    System.out.println(date);

                    todayDate = LocalDate.now();
                    System.out.println(todayDate);

                    // System.out.println(e);
                }

                // get home name
                homeName = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[2]/div[1]/span/span")).getText();
                // System.out.println("homeName = " + homeName );

                // get away name
                awayName = driver.findElement(By.xpath("//*[@id=\"match\"]/div/div[2]/div[3]/span/span")).getText();
                // System.out.println("awayName = " + awayName );

//			if(homeName.contains("(w)")
//					|| awayName.contains("(w)")
//					|| homeName.contains("Reserve")
//					|| awayName.contains("Reserve")
//					|| homeName.contains("(Youth)")
//					|| awayName.contains("(Youth)")
//					|| homeName.contains("U20")
//					|| awayName.contains("U20")
//					|| homeName.contains("U23")
//					|| awayName.contains("U23")
//					|| homeName.contains("U21")
//					|| awayName.contains("U21")
//					|| homeName.contains("U19")
//					|| awayName.contains("U19"))
//				continue;

                if (games.equals("20")) {
                    driver.findElement(By.xpath("//*[@id='f6']/span/select")).click();
                    driver.findElement(By.xpath("//*[@id='f6']/span/select/option[2]")).click();
                }

                if (sameLeague == true) {

                    driver.findElement(By.xpath("//*[@id='f6']/span/label[1]")).click();

                }
//			 if(mode.equals("H/A Same"))
//			 {
//
//				driver.findElement(By.xpath("//*[@id='f6']/span/label[2]")).click();
//
//			 }

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
                        driver.findElement(By.xpath("//*[@id=\"f6\"]/span/label[2]")).click();
                    }

                    try {
                        driver.findElement(By.xpath("//*[@id=\"f6\"]/span/label[2]")).click();
                        driver.findElement(By.xpath("//*[@id=\"f6\"]/span/label[2]")).click();
                        driver.findElement(By.xpath("//*[@id=\"f6\"]/span/label[2]")).click();
                        driver.findElement(By.xpath("//*[@id=\"f6\"]/span/label[2]")).click();

                    } catch (Exception e) {
                        // System.out.println("No boxes to click");

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

                            LocalDate matchDate = LocalDate.parse(matchDay, formatter);
                            Period period = Period.between(matchDate, todayDate);
                            days = period.getDays() + (period.getMonths() * 30) + (period.getYears() * 365);
                            // System.out.println("Days since last match = " + days );

                            if (days < 40)
                                leagueGameHome++;

//						    if(  leagueGameHome < 1)
//						    	break;

//						    if(days  > 180) {
//						    	i++;
//						    	continue;
//						     }

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
//						System.out.println("no more home goals");
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

                            LocalDate matchDate = LocalDate.parse(matchDay, formatter);

                            Period period = Period.between(matchDate, todayDate);

                            days = period.getDays() + (period.getMonths() * 30) + (period.getYears() * 365);
                            // System.out.println("Days since last match = " + days );

                            if (days < 40)
                                leagueGameAway++;

//							    if( leagueGameAway < 1)
//							    	break;

//							    if(days  > 180) {
//							    	i++;
//							    	continue;
//
//							     }

                            matchResult = driver.findElement(By.xpath(
                                            "(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[4])[" + i + "]"))
                                    .getAttribute("data-cls");

                            // System.out.println("away match result = " + matchResult);

                            FTawayGoalTemp = Integer.valueOf(driver.findElement(By
                                            .xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[4]/span[1])["
                                                    + i + "]"))
                                    .getText());

                            // System.out.println("away goal = " + awayGoalTemp);

                            FTawayOppGoalTemp = Integer.valueOf(driver.findElement(By
                                            .xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[4]/span[2])["
                                                    + i + "]"))
                                    .getText());

                            // System.out.println("away opp goal = " + awayOppGoalTemp);

                            HTawayGoalTemp = Integer.valueOf(driver.findElement(By
                                            .xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[3]/span[1])["
                                                    + i + "]"))
                                    .getText());

                            // System.out.println("away goal = " + awayGoalTemp);

                            HTawayOppGoalTemp = Integer.valueOf(driver.findElement(By
                                            .xpath("(//*[@id='e6_1']/table[2]//tr[@style='display: table-row;']/td[3]/span[2])["
                                                    + i + "]"))
                                    .getText());

                            // System.out.println("away opp goal = " + awayOppGoalTemp);

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
//						System.out.println("no more away goals");
                            // System.out.println(e);
                            break;
                        }
                    }

                    ArrayList<Integer> FToneCount = new ArrayList<Integer>();
                    ArrayList<Integer> HToneCount = new ArrayList<Integer>();

                    ArrayList<Integer> twoCount = new ArrayList<Integer>();
                    ArrayList<Integer> threeCount = new ArrayList<Integer>();
                    ArrayList<Integer> fourCount = new ArrayList<Integer>();
                    ArrayList<Integer> ggCount = new ArrayList<Integer>();

                    ArrayList<Integer> homeScoredAGoal = new ArrayList<Integer>();
                    ArrayList<Integer> awayScoredAGoal = new ArrayList<Integer>();
                    ArrayList<Integer> FThomeScored = new ArrayList<Integer>();
                    ArrayList<Integer> FTawayScored = new ArrayList<Integer>();
                    ArrayList<Integer> FThomeConceded = new ArrayList<Integer>();
                    ArrayList<Integer> FTawayConceded = new ArrayList<Integer>();
                    ArrayList<Integer> HThomeScored = new ArrayList<Integer>();
                    ArrayList<Integer> HTawayScored = new ArrayList<Integer>();
                    ArrayList<Integer> HThomeConceded = new ArrayList<Integer>();
                    ArrayList<Integer> HTawayConceded = new ArrayList<Integer>();
                    ArrayList<Integer> homeConcededAGoal = new ArrayList<Integer>();
                    ArrayList<Integer> awayConcededAGoal = new ArrayList<Integer>();

                    float FToneCountRecAvg = 0, HToneCountRecAvg = 0, oneCountRegAvg = 0, twoCountRecAvg = 0,
                            twoCountRegAvg = 0, threeCountRecAvg = 0, threeCountRegAvg = 0, fourCountRecAvg = 0,
                            fourCountRegAvg = 0, ggCountRecAvg = 0, ggCountRegAvg = 0, FThomeScoredRecAvg = 0,
                            FThomeScoredRegAvg = 0, FTawayScoredRecAvg = 0, FTawayScoredRegAvg = 0,
                            FThomeConcededRecAvg = 0, FThomeConcededRegAvg = 0, FTawayConcededRecAvg = 0,
                            FTawayConcededRegAvg = 0, HThomeScoredRecAvg = 0, HThomeScoredRegAvg = 0,
                            HTawayScoredRecAvg = 0, HTawayScoredRegAvg = 0, HThomeConcededRecAvg = 0,
                            HThomeConcededRegAvg = 0, HTawayConcededRecAvg = 0, HTawayConcededRegAvg = 0,
                            homeFormRecAvg = 0, awayFormRecAvg = 0,

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

                        if (FThomeGoalTemp > 0 && FThomeOppGoalTemp > 0)
                            ggCount.add(1);
                        else
                            ggCount.add(0);

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
                            twoCount.add(0);
                            threeCount.add(0);
                            fourCount.add(0);
                        }

                        if (FThomeTotal == 1) {
                            FToneCount.add(1);
                            twoCount.add(0);
                            threeCount.add(0);
                            fourCount.add(0);
                        }

                        if (FThomeTotal == 2) {
                            FToneCount.add(1);
                            twoCount.add(1);
                            threeCount.add(0);
                            fourCount.add(0);
                        }

                        if (FThomeTotal == 3) {
                            FToneCount.add(1);
                            twoCount.add(1);
                            threeCount.add(1);
                            fourCount.add(0);
                        }

                        if (FThomeTotal >= 4) {
                            FToneCount.add(1);
                            twoCount.add(1);
                            threeCount.add(1);
                            fourCount.add(1);
                        }

                    }

                    float sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0, sum6 = 0, sum7 = 0, sum8 = 0, sum9 = 0,
                            sum10 = 0, sum11 = 0, sum12 = 0, sum13 = 0;

                    ArrayList<Float> homeFormRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> awayFormRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> FToneCountRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> HToneCountRecAvgArr = new ArrayList<Float>();

                    ArrayList<Float> twoCountRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> threeCountRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> fourCountRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> ggCountRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> FThomeScoredRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> FTawayScoredRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> FThomeConcededRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> FTawayConcededRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> HThomeScoredRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> HTawayScoredRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> HThomeConcededRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> HTawayConcededRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> homeScoredAGoalRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> awayScoredAGoalRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> homeConcededAGoalRecAvgArr = new ArrayList<Float>();
                    ArrayList<Float> awayConcededAGoalRecAvgArr = new ArrayList<Float>();

                    for (i = 0; i < homeForm.size(); i++) {

                        sum1 += FToneCount.get(i);
                        FToneCountRecAvgArr.add(sum1 / (i + 1));

                        sum13 += HToneCount.get(i);
                        HToneCountRecAvgArr.add(sum13 / (i + 1));

                        sum2 += twoCount.get(i);
                        twoCountRecAvgArr.add(sum2 / (i + 1));

                        sum3 += threeCount.get(i);
                        threeCountRecAvgArr.add(sum3 / (i + 1));

                        sum4 += fourCount.get(i);
                        fourCountRecAvgArr.add(sum4 / (i + 1));

                        sum5 += ggCount.get(i);
                        ggCountRecAvgArr.add(sum5 / (i + 1));

                        sum6 += FThomeGoals.get(i);
                        FThomeScoredRecAvgArr.add(sum6 / (i + 1));

                        sum7 += FThomeOppGoals.get(i);
                        FThomeConcededRecAvgArr.add(sum7 / (i + 1));

                        sum11 += HThomeGoals.get(i);
                        HThomeScoredRecAvgArr.add(sum11 / (i + 1));

                        sum12 += HThomeOppGoals.get(i);
                        HThomeConcededRecAvgArr.add(sum12 / (i + 1));

                        sum8 += homeScoredAGoal.get(i);
                        homeScoredAGoalRecAvgArr.add(sum8 / (i + 1));

                        sum9 += homeConcededAGoal.get(i);
                        homeConcededAGoalRecAvgArr.add(sum9 / (i + 1));

                        sum10 += homeForm.get(i);
                        homeFormRecAvgArr.add(sum10 / (i + 1));

                    }

                    oneCountRegAvg = sum1 / homeForm.size();

                    twoCountRegAvg = sum2 / homeForm.size();
                    threeCountRegAvg = sum3 / homeForm.size();
                    fourCountRegAvg = sum4 / homeForm.size();
                    ggCountRegAvg = sum5 / homeForm.size();
                    FThomeScoredRegAvg = sum6 / homeForm.size();
                    FThomeConcededRegAvg = sum7 / homeForm.size();
                    HThomeScoredRegAvg = sum11 / homeForm.size();
                    HThomeConcededRegAvg = sum12 / homeForm.size();
                    homeScoredAGoalRegAvg = sum8 / homeForm.size();
                    homeConcededAGoalRegAvg = sum9 / homeForm.size();
                    homeFormRegAvg = sum10 / homeForm.size();

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
                        sum13 += HToneCountRecAvgArr.get(i);

                        sum2 += twoCountRecAvgArr.get(i);
                        sum3 += threeCountRecAvgArr.get(i);
                        sum4 += fourCountRecAvgArr.get(i);
                        sum5 += ggCountRecAvgArr.get(i);
                        sum6 += FThomeScoredRecAvgArr.get(i);
                        sum7 += FThomeConcededRecAvgArr.get(i);
                        sum11 += HThomeScoredRecAvgArr.get(i);
                        sum12 += HThomeConcededRecAvgArr.get(i);
                        sum8 += homeScoredAGoalRecAvgArr.get(i);
                        sum9 += homeConcededAGoalRecAvgArr.get(i);
                        sum10 += homeFormRecAvgArr.get(i);

                    }

                    FToneCountRecAvg = sum1 / homeForm.size();
                    HToneCountRecAvg = sum13 / homeForm.size();

                    twoCountRecAvg = sum2 / homeForm.size();
                    threeCountRecAvg = sum3 / homeForm.size();
                    fourCountRecAvg = sum4 / homeForm.size();
                    ggCountRecAvg = sum5 / homeForm.size();
                    FThomeScoredRecAvg = sum6 / homeForm.size();
                    FThomeConcededRecAvg = sum7 / homeForm.size();
                    HThomeScoredRecAvg = sum11 / homeForm.size();
                    HThomeConcededRecAvg = sum12 / homeForm.size();
                    homeScoredAGoalRecAvg = sum8 / homeForm.size();
                    homeConcededAGoalRecAvg = sum9 / homeForm.size();
                    homeFormRecAvg = sum10 / homeForm.size();

                    FThomeOneRecProb = FToneCountRecAvg;
                    HThomeOneRecProb = HToneCountRecAvg;

                    homeTwoRecProb = twoCountRecAvg;
                    homeThreeRecProb = threeCountRecAvg;
                    homeFourRecProb = fourCountRecAvg;
                    float homeGGRecProb = ggCountRecAvg;
                    float homeOneRegProb = oneCountRegAvg;
                    float homeTwoRegProb = twoCountRegAvg;
                    float homeThreeRegProb = threeCountRegAvg;
                    float homeFourRegProb = fourCountRegAvg;
                    float homeGGRegProb = ggCountRegAvg;
                    float homeFormRegProb = homeFormRegAvg;
                    homeFormRecProb = homeFormRecAvg;
                    float homeScoredRegProb = FThomeScoredRegAvg;
                    FThomeScoredRecProb = FThomeScoredRecAvg;
                    float homeConcededRegProb = FThomeConcededRegAvg;
                    FThomeConcededRecProb = FThomeConcededRecAvg;
                    HThomeScoredRecProb = HThomeScoredRecAvg;
                    HThomeConcededRecProb = HThomeConcededRecAvg;
                    float homeScoredAGoalRegProb = homeScoredAGoalRegAvg;
                    float homeScoredAGoalRecProb = homeScoredAGoalRecAvg;
                    float homeConcededAGoalRegProb = homeConcededAGoalRegAvg;
                    float homeConcededAGoalRecProb = homeConcededAGoalRecAvg;

                    FToneCount.clear();
                    HToneCount.clear();
                    twoCount.clear();
                    threeCount.clear();
                    fourCount.clear();
                    ggCount.clear();

                    for (i = 0; i < awayForm.size(); i++) {

                        FTawayGoalTemp = FTawayGoals.get(i);
                        FTawayOppGoalTemp = FTawayOppGoals.get(i);

                        FTawayTotal = FTawayGoalTemp + FTawayOppGoalTemp;

                        HTawayGoalTemp = HTawayGoals.get(i);
                        HTawayOppGoalTemp = HTawayOppGoals.get(i);

                        HTawayTotal = HTawayGoalTemp + HTawayOppGoalTemp;

                        if (FTawayGoalTemp > 0 && FTawayOppGoalTemp > 0)
                            ggCount.add(1);
                        else
                            ggCount.add(0);

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
                            twoCount.add(0);
                            threeCount.add(0);
                            fourCount.add(0);
                        }

                        if (FTawayTotal == 1) {
                            FToneCount.add(1);
                            twoCount.add(0);
                            threeCount.add(0);
                            fourCount.add(0);
                        }

                        if (FTawayTotal == 2) {
                            FToneCount.add(1);
                            twoCount.add(1);
                            threeCount.add(0);
                            fourCount.add(0);
                        }

                        if (FTawayTotal == 3) {
                            FToneCount.add(1);
                            twoCount.add(1);
                            threeCount.add(1);
                            fourCount.add(0);
                        }

                        if (FTawayTotal >= 4) {
                            FToneCount.add(1);
                            twoCount.add(1);
                            threeCount.add(1);
                            fourCount.add(1);
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
                    HToneCountRecAvgArr.clear();

                    twoCountRecAvgArr.clear();
                    threeCountRecAvgArr.clear();
                    fourCountRecAvgArr.clear();
                    ggCountRecAvgArr.clear();

                    for (i = 0; i < awayForm.size(); i++) {

                        sum1 += FToneCount.get(i);
                        FToneCountRecAvgArr.add(sum1 / (i + 1));
                        sum13 += HToneCount.get(i);
                        HToneCountRecAvgArr.add(sum13 / (i + 1));

                        sum2 += twoCount.get(i);
                        twoCountRecAvgArr.add(sum2 / (i + 1));

                        sum3 += threeCount.get(i);
                        threeCountRecAvgArr.add(sum3 / (i + 1));

                        sum4 += fourCount.get(i);
                        fourCountRecAvgArr.add(sum4 / (i + 1));

                        sum5 += ggCount.get(i);
                        ggCountRecAvgArr.add(sum5 / (i + 1));

                        sum6 += FTawayGoals.get(i);
                        FTawayScoredRecAvgArr.add(sum6 / (i + 1));

                        sum7 += FTawayOppGoals.get(i);
                        FTawayConcededRecAvgArr.add(sum7 / (i + 1));

                        sum11 += HTawayGoals.get(i);
                        HTawayScoredRecAvgArr.add(sum11 / (i + 1));

                        sum12 += HTawayOppGoals.get(i);
                        HTawayConcededRecAvgArr.add(sum12 / (i + 1));

                        sum8 += awayScoredAGoal.get(i);
                        awayScoredAGoalRecAvgArr.add(sum8 / (i + 1));

                        sum9 += awayConcededAGoal.get(i);
                        awayConcededAGoalRecAvgArr.add(sum9 / (i + 1));

                        sum10 += awayForm.get(i);
                        awayFormRecAvgArr.add(sum10 / (i + 1));

                    }

                    FToneCountRecAvg = 0;
                    HToneCountRecAvg = 0;

                    twoCountRecAvg = 0;
                    threeCountRecAvg = 0;
                    fourCountRecAvg = 0;
                    ggCountRecAvg = 0;

                    oneCountRegAvg = sum1 / awayForm.size();
                    twoCountRegAvg = sum2 / awayForm.size();
                    threeCountRegAvg = sum3 / awayForm.size();
                    fourCountRegAvg = sum4 / awayForm.size();
                    ggCountRegAvg = sum5 / awayForm.size();
                    FTawayScoredRegAvg = sum6 / awayForm.size();
                    FTawayConcededRegAvg = sum7 / awayForm.size();
                    HTawayScoredRegAvg = sum11 / awayForm.size();
                    HTawayConcededRegAvg = sum12 / awayForm.size();
                    awayScoredAGoalRegAvg = sum8 / awayForm.size();
                    awayConcededAGoalRegAvg = sum9 / awayForm.size();
                    awayFormRegAvg = sum10 / awayForm.size();

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
                        sum13 += HToneCountRecAvgArr.get(i);

                        sum2 += twoCountRecAvgArr.get(i);
                        sum3 += threeCountRecAvgArr.get(i);
                        sum4 += fourCountRecAvgArr.get(i);
                        sum5 += ggCountRecAvgArr.get(i);
                        sum6 += FTawayScoredRecAvgArr.get(i);
                        sum7 += FTawayConcededRecAvgArr.get(i);
                        sum11 += HTawayScoredRecAvgArr.get(i);
                        sum12 += HTawayConcededRecAvgArr.get(i);
                        sum8 += awayScoredAGoalRecAvgArr.get(i);
                        sum9 += awayConcededAGoalRecAvgArr.get(i);
                        sum10 += awayFormRecAvgArr.get(i);

                    }

                    FToneCountRecAvg = sum1 / awayForm.size();
                    HToneCountRecAvg = sum13 / awayForm.size();

                    twoCountRecAvg = sum2 / awayForm.size();
                    threeCountRecAvg = sum3 / awayForm.size();
                    fourCountRecAvg = sum4 / awayForm.size();
                    ggCountRecAvg = sum5 / awayForm.size();
                    FTawayScoredRecAvg = sum6 / awayForm.size();
                    FTawayConcededRecAvg = sum7 / awayForm.size();
                    HTawayScoredRecAvg = sum11 / awayForm.size();
                    HTawayConcededRecAvg = sum12 / awayForm.size();
                    awayScoredAGoalRecAvg = sum8 / awayForm.size();
                    awayConcededAGoalRecAvg = sum9 / awayForm.size();
                    awayFormRecAvg = sum10 / awayForm.size();

                    FTawayOneRecProb = FToneCountRecAvg;
                    HTawayOneRecProb = HToneCountRecAvg;

                    awayTwoRecProb = twoCountRecAvg;
                    awayThreeRecProb = threeCountRecAvg;
                    awayFourRecProb = fourCountRecAvg;
                    float awayGGRecProb = ggCountRecAvg;
                    float awayOneRegProb = oneCountRegAvg;
                    float awayTwoRegProb = twoCountRegAvg;
                    float awayThreeRegProb = threeCountRegAvg;
                    float awayFourRegProb = fourCountRegAvg;
                    float awayGGRegProb = ggCountRegAvg;
                    float awayFormRegProb = awayFormRegAvg;
                    awayFormRecProb = awayFormRecAvg;
                    float awayScoredRegProb = FTawayScoredRegAvg;
                    FTawayScoredRecProb = FTawayScoredRecAvg;
                    float awayConcededRegProb = FTawayConcededRegAvg;
                    FTawayConcededRecProb = FTawayConcededRecAvg;
                    HTawayScoredRecProb = HTawayScoredRecAvg;
                    HTawayConcededRecProb = HTawayConcededRecAvg;
                    float awayScoredAGoalRegProb = awayScoredAGoalRegAvg;
                    float awayScoredAGoalRecProb = awayScoredAGoalRecAvg;
                    float awayConcededAGoalRegProb = awayConcededAGoalRegAvg;
                    float awayConcededAGoalRecProb = awayConcededAGoalRecAvg;

                    FThomeExpectedRecProb = (FThomeScoredRecProb + FTawayConcededRecProb) / 2;
                    FTawayExpectedRecProb = (FTawayScoredRecProb + FThomeConcededRecProb) / 2;
                    HThomeExpectedRecProb = (HThomeScoredRecProb + HTawayConcededRecProb) / 2;
                    HTawayExpectedRecProb = (HTawayScoredRecProb + HThomeConcededRecProb) / 2;
                    homeScoredAGoalExpectedRecProb = (homeScoredAGoalRecProb + awayConcededAGoalRecProb) / 2;
                    awayScoredAGoalExpectedRecProb = (awayScoredAGoalRecProb + homeConcededAGoalRecProb) / 2;

                    FTtotalExpectedProb = Math.max(homeScoredAGoalExpectedRecProb, awayScoredAGoalExpectedRecProb);
                    FTtotalExpectedRecProb = FThomeExpectedRecProb + FTawayExpectedRecProb;

                    HTtotalExpectedRecProb = HThomeExpectedRecProb + HTawayExpectedRecProb;

                    formDiffRec = Math.abs(homeFormRecProb - awayFormRecProb);
                    maxForm = Math.max(homeFormRecProb, awayFormRecProb);
                    FTmaxOne = Math.min(FThomeOneRecProb, FTawayOneRecProb);
                    HTmaxOne = Math.min(HThomeOneRecProb, HTawayOneRecProb);

                    maxTwo = Math.min(homeTwoRecProb, awayTwoRecProb);
                    maxThree = Math.min(homeThreeRecProb, awayThreeRecProb);
                    maxFour = Math.min(homeFourRecProb, awayFourRecProb);

                    if (neutral) {

                        FTneutralHomeScoredRecProb = FThomeScoredRecProb;
                        FTneutralAwayScoredRecProb = FTawayScoredRecProb;
                        FTneutralHomeConcededRecProb = FThomeConcededRecProb;
                        FTneutralAwayConcededRecProb = FTawayScoredRecProb;

                        FTneutralHomeExpectedRecProb = FThomeExpectedRecProb;
                        FTneutralAwayExpectedRecProb = FTawayExpectedRecProb;
                        neutralHomeScoredAGoalExpectedRecProb = (homeScoredAGoalRecProb + awayConcededAGoalRecProb) / 2;
                        neutralAwayScoredAGoalExpectedRecProb = (awayScoredAGoalRecProb + homeConcededAGoalRecProb) / 2;

                        FTneutralTotalExpectedProb = Math.max(homeScoredAGoalExpectedRecProb,
                                awayScoredAGoalExpectedRecProb);
                        FTneutralTotalExpectedRecProb = FThomeExpectedRecProb + FTawayExpectedRecProb;

                        HTneutralHomeScoredRecProb = HThomeScoredRecProb;
                        HTneutralAwayScoredRecProb = HTawayScoredRecProb;
                        HTneutralHomeConcededRecProb = HThomeConcededRecProb;
                        HTneutralAwayConcededRecProb = HTawayConcededRecProb;

                        HTneutralHomeExpectedRecProb = HThomeExpectedRecProb;
                        HTneutralAwayExpectedRecProb = HTawayExpectedRecProb;

                        HTneutralTotalExpectedProb = Math.max(homeScoredAGoalExpectedRecProb,
                                awayScoredAGoalExpectedRecProb);
                        HTneutralTotalExpectedRecProb = HThomeExpectedRecProb + HTawayExpectedRecProb;

                        neutralHomeFormRecProb = homeFormRecProb;
                        neutralAwayFormRecProb = awayFormRecProb;

                        FTneutralHomeOneRecProb = FThomeOneRecProb;
                        HTneutralHomeOneRecProb = HThomeOneRecProb;

                        neutralHomeTwoRecProb = homeTwoRecProb;
                        neutralHomeThreeRecProb = homeThreeRecProb;
                        neutralHomeFourRecProb = homeFourRecProb;
                        FTneutralAwayOneRecProb = FTawayOneRecProb;
                        HTneutralAwayOneRecProb = HTawayOneRecProb;

                        neutralAwayTwoRecProb = awayTwoRecProb;
                        neutralAwayThreeRecProb = awayThreeRecProb;
                        neutralAwayFourRecProb = awayFourRecProb;

                        neturalFormDiffRec = Math.abs(neutralHomeFormRecProb - neutralAwayFormRecProb);
                        neutralMaxForm = Math.max(homeFormRecProb, awayFormRecProb);
                        FTneutralMaxOne = Math.min(FThomeOneRecProb, FTawayOneRecProb);
                        HTneutralMaxOne = Math.min(HThomeOneRecProb, HTawayOneRecProb);

                        neutralMaxTwo = Math.min(homeTwoRecProb, awayTwoRecProb);
                        neutralMaxThree = Math.min(homeThreeRecProb, awayThreeRecProb);
                        neutralMaxFour = Math.min(homeFourRecProb, awayFourRecProb);

                        FTneutralHomeGoals.addAll(FThomeGoals);
                        FTneutralAwayGoals.addAll(FTawayGoals);
                        FTneutralHomeOppGoals.addAll(FThomeOppGoals);
                        FTneutralAwayOppGoals.addAll(FTawayOppGoals);
                        HTneutralHomeGoals.addAll(HThomeGoals);
                        HTneutralAwayGoals.addAll(HTawayGoals);
                        HTneutralHomeOppGoals.addAll(HThomeOppGoals);
                        HTneutralAwayOppGoals.addAll(HTawayOppGoals);
                        neutralHomeForm.addAll(homeForm);
                        neutralAwayForm.addAll(awayForm);

                    }

                    neutral = false;

                } // h/a for loop

                double betThis = 0.0;
                int tier = 1;
                String htBetThis = "";

                Integer h2hHome0 = null;
                Integer h2hAway0 = null;
                Integer h2hHome1 = null;
                Integer h2hAway1 = null;

// get last two matches played h2h
                try {
                    h2hHome0 = Integer.valueOf(driver.findElement(By.xpath("//*[@id='e5_1']/table/tbody/tr[2]/td[5]/span[1]")).getText());
                    h2hAway0 = Integer.valueOf(driver.findElement(By.xpath("//*[@id='e5_1']/table/tbody/tr[2]/td[5]/span[2]")).getText());
                    h2hHome1 = Integer.valueOf(driver.findElement(By.xpath("//*[@id='e5_1']/table/tbody/tr[3]/td[5]/span[1]")).getText());
                    h2hAway1 = Integer.valueOf(driver.findElement(By.xpath("//*[@id='e5_1']/table/tbody/tr[3]/td[5]/span[2]")).getText());
                }catch(Exception e){

                }


//                if(h2hHome0 != null && h2hHome0 == 0 && h2hAway0 == 0 )
//                {
//                    continue;
//
//                }
//
//                if(h2hHome1 != null && h2hHome1 == 0 && h2hAway1 == 0 )
//                {
//                    continue;
//                }


                // get odds
                // click odds tab
                driver.findElement(By.xpath("//*[@id=\"match\"]/nav/div[3]/a")).click();
                // click 1x2 tab
                driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/a[1]")).click();

                // grab home odds (min)
                String homeOddsS = driver.findElement(By.xpath("//*[@id=\"oContent\"]/table/tbody/tr[5]/td[2]"))
                        .getText();

                // grab away odds (min)
                String awayOddsS = driver.findElement(By.xpath("//*[@id=\"oContent\"]/table/tbody/tr[5]/td[4]"))
                        .getText();

                double homeOdds = Double.parseDouble(homeOddsS);
                double awayOdds = Double.parseDouble(awayOddsS);
                double oddsDiff = Math.abs(homeOdds - awayOdds);
                double minOdds = Math.min(homeOdds, awayOdds);

                double FTtotalHomeScoredRecProb = Math.max(FTneutralHomeScoredRecProb, FThomeScoredRecProb);
                double FTtotalAwayScoredRecProb = Math.max(FTneutralAwayScoredRecProb, FTawayScoredRecProb);
                double FTtotalScoredRecProb = FTtotalHomeScoredRecProb + FTtotalAwayScoredRecProb;
                double maxFTtotalScoredRecProb = Math.max(FTtotalHomeScoredRecProb, FTtotalAwayScoredRecProb);

                double FTtotalHomeConcededRecProb = Math.max(FTneutralHomeConcededRecProb, FThomeConcededRecProb);
                double FTtotalAwayConcededRecProb = Math.max(FTneutralAwayConcededRecProb, FTawayConcededRecProb);
                double FTtotalConcededRecProb = FTtotalHomeConcededRecProb + FTtotalAwayConcededRecProb;
                double maxFTtotalConcededRecProb = Math.max(FTtotalHomeConcededRecProb, FTtotalAwayConcededRecProb);

                double FTtotalHomeExpectedRecProb = Math.min(FTtotalHomeScoredRecProb, FTtotalAwayConcededRecProb);
                double FTtotalAwayExpectedRecProb = Math.min(FTtotalAwayScoredRecProb, FTtotalHomeConcededRecProb);
                double FTtotalMinHomeExpectedRecProb = Math.min(FTtotalHomeScoredRecProb, FTtotalAwayConcededRecProb);
                double FTtotalMinAwayExpectedRecProb = Math.min(FTtotalAwayScoredRecProb, FTtotalHomeConcededRecProb);
                double FTtotalMinExpectedRecProb = FTtotalMinHomeExpectedRecProb + FTtotalMinAwayExpectedRecProb;

                double HTtotalHomeScoredRecProb = Math.max(HTneutralHomeScoredRecProb, HThomeScoredRecProb);
                double HTtotalAwayScoredRecProb = Math.max(HTneutralAwayScoredRecProb, HTawayScoredRecProb);
                double HTtotalScoredRecProb = HTtotalHomeScoredRecProb + HTtotalAwayScoredRecProb;

                double HTtotalHomeConcededRecProb = Math.max(HTneutralHomeConcededRecProb, HThomeConcededRecProb);
                double HTtotalAwayConcededRecProb = Math.max(HTneutralAwayConcededRecProb, HTawayConcededRecProb);
                double HTtotalConcededRecProb = HTtotalHomeConcededRecProb + HTtotalAwayConcededRecProb;

                double HTtotalHomeExpectedRecProb = Math.min(HTtotalHomeScoredRecProb, HTtotalAwayConcededRecProb);
                double HTtotalAwayExpectedRecProb = Math.min(HTtotalAwayScoredRecProb, HTtotalHomeConcededRecProb);

                double totalHomeScoredAGoalExpectedRecProb = Math.max(neutralHomeScoredAGoalExpectedRecProb
                        , homeScoredAGoalExpectedRecProb);
                double totalAwayScoredAGoalExpectedRecProb = Math.max(neutralAwayScoredAGoalExpectedRecProb
                        , awayScoredAGoalExpectedRecProb);

                double totalTotalExpectedRecProb = Math.min(totalHomeScoredAGoalExpectedRecProb,
                        totalAwayScoredAGoalExpectedRecProb);

                double totalHomeFormRecProb = Math.max(neutralHomeFormRecProb, homeFormRecProb);
                double totalAwayFormRecProb = Math.max(neutralAwayFormRecProb, awayFormRecProb);

                double FTtotalHomeOneRecProb = Math.max(FTneutralHomeOneRecProb, FThomeOneRecProb);
                double HTtotalHomeOneRecProb = Math.max(HTneutralHomeOneRecProb, HThomeOneRecProb);

                double FTtotalHomeTwoRecProb = Math.max(neutralHomeTwoRecProb, homeTwoRecProb);
                double FTtotalHomeThreeRecProb = Math.max(neutralHomeThreeRecProb, homeThreeRecProb);
                double FTtotalHomeFourRecProb = Math.max(neutralHomeFourRecProb, homeFourRecProb);
                double FTtotalAwayOneRecProb = Math.max(FTneutralAwayOneRecProb, FTawayOneRecProb);
                double HTtotalAwayOneRecProb = Math.max(HTneutralAwayOneRecProb, HTawayOneRecProb);

                double FTtotalAwayTwoRecProb = Math.max(neutralAwayTwoRecProb, awayTwoRecProb);
                double FTtotalAwayThreeRecProb = Math.max(neutralAwayThreeRecProb, awayThreeRecProb);
                double FTtotalAwayFourRecProb = Math.max(neutralAwayFourRecProb, awayFourRecProb);
                double totalFormDiffRec = Math.abs(totalHomeFormRecProb - totalAwayFormRecProb);
                double totalMaxForm = Math.max(totalHomeFormRecProb, totalAwayFormRecProb);
                double totalMinForm = Math.min(totalHomeFormRecProb, totalAwayFormRecProb);

                double FTtotalMinOne = Math.min(FTtotalHomeOneRecProb, FTtotalAwayOneRecProb);
                double HTtotalMinOne = Math.min(HTtotalHomeOneRecProb, HTtotalAwayOneRecProb);

                double FTtotalMinTwo = Math.min(FTtotalHomeTwoRecProb, FTtotalAwayTwoRecProb);
                double FTtotalMinThree = Math.min(FTtotalHomeThreeRecProb, FTtotalAwayThreeRecProb);
                double FTtotalMinFour = Math.min(FTtotalHomeFourRecProb, FTtotalAwayFourRecProb);
                double FTtotalMaxOne = Math.max(FTtotalHomeOneRecProb, FTtotalAwayOneRecProb);
                double HTtotalMaxOne = Math.max(HTtotalHomeOneRecProb, HTtotalAwayOneRecProb);

                double totalMaxTwo = Math.max(FTtotalHomeTwoRecProb, FTtotalAwayTwoRecProb);
                double totalMaxThree = Math.max(FTtotalHomeThreeRecProb, FTtotalAwayThreeRecProb);
                double totalMaxFour = Math.max(FTtotalHomeFourRecProb, FTtotalAwayFourRecProb);
                double FTtotalOne = Math.max(FTtotalHomeOneRecProb, FTtotalAwayOneRecProb);
                double HTtotalOne = Math.max(HTtotalHomeOneRecProb, HTtotalAwayOneRecProb);

                double HTtotalOneAvg = (HTtotalHomeOneRecProb + HTtotalAwayOneRecProb)/2;

                double FTtotalTwo = Math.max(FTtotalHomeTwoRecProb, FTtotalAwayTwoRecProb);
                double FTtotalThree = Math.max(FTtotalHomeThreeRecProb, FTtotalAwayThreeRecProb);
                double FTtotalFour = Math.max(FTtotalHomeFourRecProb, FTtotalAwayFourRecProb);

                double FTtotalTotalExpectedProb = (FTtotalHomeExpectedRecProb + FTtotalAwayExpectedRecProb);

                double HTtotalTotalExpectedProb = (HTtotalHomeExpectedRecProb + HTtotalAwayExpectedRecProb);

                double homeFormOdds = totalHomeFormRecProb / homeOdds;
                double awayFormOdds = totalAwayFormRecProb / awayOdds;
                double maxFormOdds = Math.max(homeFormOdds, awayFormOdds);
                double formOddsDiff = (homeFormOdds - awayFormOdds);




                if (FTtotalMinExpectedRecProb > 1 && FTtotalMinOne > 0.89999) {

                    betThis = 0.5;
                }

                if (FTtotalMinExpectedRecProb > 2 && FTtotalMinTwo > 0.8499999) {

                    betThis = 1.5;
                }

                if (FTtotalMinExpectedRecProb > 3 && FTtotalMinThree > 0.79999)
                {

                    betThis = 2.5;
                }


                if (FTtotalMinExpectedRecProb > 4 && FTtotalMinFour > 0.749999)
                {

                    betThis = 3.5;
                }




                if(FTtotalMinOne < 0.9)
                    continue;



                if (totalMaxForm < 1.5)
                    continue;
                if (HTtotalMinOne < 0.7)
                    continue;


                if ( HTtotalMinOne > 0.79999 && (FTtotalMinHomeExpectedRecProb > 1.49999  || FTtotalMinAwayExpectedRecProb > 1.49999)  )
                    htBetThis = "YES";

//                if(minOdds > 1.7999 && totalMinForm >  1.49999)
//                    continue;
//
//                if(totalMinForm > 1.49999)
//                    continue;

//                if(totalMinForm > 1.39999)
//                    tier++;





                if (htBetThis.contentEquals(""))
                    htBetThis = "NEVER";



                if (neutralHomeForm.get(0).equals(0) && formOddsDiff > 0 )
                    continue;

                if (neutralAwayForm.get(0).equals(0) && formOddsDiff < 0 )
                    continue;

                if (neutralHomeForm.get(1).equals(0) && formOddsDiff > 0 )
                    htBetThis = "NEVER";

                if (neutralAwayForm.get(1).equals(0) && formOddsDiff < 0 )
                    htBetThis = "NEVER";

                if (neutralHomeForm.get(2).equals(0) && formOddsDiff > 0 )
                    htBetThis = "NEVER";

                if (neutralAwayForm.get(2).equals(0) && formOddsDiff < 0 )
                    htBetThis = "NEVER";


                if((totalHomeFormRecProb < totalAwayFormRecProb) && (homeOdds < awayOdds) && formOddsDiff < 1 )
                    continue;

                if((totalAwayFormRecProb < totalHomeFormRecProb) && (awayOdds < homeOdds) && formOddsDiff < 1 )
                    continue;




                if(  league2.contains("Ireland Leinster Senior") || league2.contains("Norway Division 4")
                        || league2.contains("Israel C League")
                        || league2.contains("Turkey 3. Ligi B")
                        || league2.contains("Belgian First Amateur Division")
                        || league2.contains("Czech Republic 5. Ligy")
                        || league2.contains("Kolmonen")
                        || league2.contains("Northern German state premier league - bayern")
                        || league2.contains("Denmark - 4.Liga") || league2.contains("Poland Division 4")
                        || league2.contains("Spain Regional League")
                        || league2.contains("Spanish Bizkaia-Tercera Division")
                        || league2.contains("Schleswig Holstein Liga")
                        || league2.contains("Landesliga")
                        || league2.contains("Tanzania")
                        || league2.contains("Czech Group D League")
                        || league2.contains("Slovakia 3.Liga")
                        || league2.contains("Thai Division 1 League")
                        || league2.contains("Czech Republic Ceska Fotbalova Liga")
                        || league2.contains("Hungary NB III")
                        || league2.contains("Russia Division 2")  || league2.contains("Esi Liiga") || league2.contains("Mexico Segunda")
                        || league2.contains("Conference")
                        //|| league2.contains("Romania - Liga 3 Seria")
                        || league2.contains("Thai Division 2 League")
                        || league2.contains("Germany Regionalliga")
                        || league2.contains("Germany Oberliga")
                        || league2.contains("Austria 3.Liga")
                        || league2.contains("Amateur")
                       || league2.contains("Swiss")
                        || league2.contains("Friendly")
                        || league2.contains("Malta First Division")
                || league2.contains("Women") || league2.contains("Argentina Torneo B") ||   league2.contains("Sweden Div 3 Mellersta")  || league2.contains("women") || league2.contains("Feminines") || league2.contains("WE League")|| league2.contains("Frauen") || league2.contains("Woman") || league2.contains("Femenil") || league2.contains("Ladies") 	|| league2.contains("Damallsvenskan") || league2.contains("WPL"))

                {
                   htBetThis = "NEVER";
                }





                if(htBetThis.contains("YES") && betThis > 1)
                    betThis = betThis - 1;



if(totalHomeFormRecProb == 0.0)
    totalHomeFormRecProb = 0.0001;

                if(totalAwayFormRecProb == 0.0)
                    totalAwayFormRecProb = 0.0001;
                if(FTtotalMinHomeExpectedRecProb == 0.0)
                    FTtotalMinHomeExpectedRecProb = 0.0001;
                if(FTtotalMinAwayExpectedRecProb == 0.0)
                    FTtotalMinAwayExpectedRecProb = 0.0001;

                if (betThis == 0.0 || betThis < 0)
                    continue;

                if ( formOddsDiff < 0) {
                    continue;
                }

                if(minOdds > 1.89999 && betThis == 0.5 && htBetThis.equals("YES" +
                        ""))
                    htBetThis = "NEVER";
                if(betThis == 0.5 && htBetThis.equals("NEVER"))
                    continue;


                if (

                    // leagueGameHome > 0 && leagueGameAway > 0
                        true

                ) {
                    myWriter.write(date + " " + time);
                    myWriter.write(",");
                    myWriter.write(homeName);
                    myWriter.write(",");
                    myWriter.write(Double.toString(totalHomeFormRecProb).substring(0, 4));
                    myWriter.write(",");
                    myWriter.write(awayName);
                    myWriter.write(",");
                    myWriter.write(Double.toString(totalAwayFormRecProb).substring(0, 4));
                    myWriter.write(",");
                    myWriter.write(Double.toString(betThis));
                    myWriter.write(",");
                    myWriter.write(htBetThis);
                    myWriter.write(",");
                    if(tier == 1)
                    myWriter.write("Tier -> 1 (100% Max Bet)");
                    if(tier == 2)
                        myWriter.write("Tier -> 2 (20% Max Bet)");
                    if(tier == 3)
                        myWriter.write("Tier -> 3 (10% Max Bet)");
                    if(tier == 4)
                        myWriter.write("Tier -> 4 (5% Max Bet)");
                    myWriter.write(",");
                    myWriter.write(link);

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
                    System.out.format("|%-25s|", "Form");
                    System.out.format("|%-25s|", Double.toString(totalHomeFormRecProb).substring(0, 4));
                    System.out.format("|%-25s|", Double.toString(totalAwayFormRecProb).substring(0, 4));
                    System.out.format("|%-25s|", Double.toString(totalFormDiffRec).substring(0, 4));
                    System.out.println();
                    System.out.format("|%-25s|", "Odds");
                    System.out.format("|%-25s|", homeOdds);
                    System.out.format("|%-25s|", awayOdds);
                    System.out.format("|%-25s|", Double.toString(formOddsDiff).substring(0, 4));
                    System.out.println();
//					System.out.format("|%-25s|", "Form/Odds");
//					System.out.format("|%-25s|", Double.toString(homeFormOdds).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(awayFormOdds).substring(0, 4));
//					System.out.format("|%-25s|", "");
//					System.out.println();
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
//					System.out.format("|%-25s|", "Game Data");
//					System.out.format("|%-25s|", homeGoals.size());
//					System.out.format("|%-25s|", awayGoals.size());
//					System.out.format("|%-25s|", "");
//					System.out.println();
                    System.out.format("|%-25s|", "FT Expected Score");
                    System.out.format("|%-25s|", Double.toString(FTtotalMinHomeExpectedRecProb).substring(0, 4));
                    System.out.format("|%-25s|", Double.toString(FTtotalMinAwayExpectedRecProb).substring(0, 4));
                    System.out.format("|%-25s|", Double.toString(FTtotalMinExpectedRecProb).substring(0, 4));
                    System.out.println();
//					System.out.format("|%-25s|", "FT Expected Scoring");
//					System.out.format("|%-25s|", Double.toString(FTtotalHomeScoredRecProb).substring(0, 3));
//					System.out.format("|%-25s|", Double.toString(FTtotalAwayScoredRecProb).substring(0, 3));
//					System.out.format("|%-25s|", Double.toString(FTtotalScoredRecProb).substring(0, 3));
//					System.out.println();
//					System.out.format("|%-25s|", "FT Expected Defending");
//					System.out.format("|%-25s|", Double.toString(FTtotalHomeConcededRecProb).substring(0, 3));
//					System.out.format("|%-25s|", Double.toString(FTtotalAwayConcededRecProb).substring(0, 3));
//					System.out.format("|%-25s|", Double.toString(FTtotalConcededRecProb).substring(0, 3));
//					System.out.println();
//					System.out.format("|%-25s|", "HT Expected Score");
//					System.out.format("|%-25s|", Double.toString(HTtotalHomeExpectedRecProb).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(HTtotalAwayExpectedRecProb).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(HTtotalTotalExpectedProb).substring(0, 4));
//					System.out.println();
//					System.out.format("|%-25s|", "HT Expected Scoring");
//					System.out.format("|%-25s|", Double.toString(HTtotalHomeScoredRecProb).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(HTtotalAwayScoredRecProb).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(HTtotalScoredRecProb).substring(0, 4));
//					System.out.println();
//					System.out.format("|%-25s|", "HT Expected Defending");
//					System.out.format("|%-25s|", Double.toString(HTtotalHomeConcededRecProb).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(HTtotalAwayConcededRecProb).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(HTtotalConcededRecProb).substring(0, 4));
//					System.out.println();
//					System.out.format("|%-25s|", "Score Prob");
//					System.out.format("|%-25s|", Double.toString(totalHomeScoredAGoalExpectedRecProb).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(totalAwayScoredAGoalExpectedRecProb).substring(0, 4));
//					System.out.format("|%-25s|", Double.toString(totalTotalExpectedRecProb).substring(0, 4));
//					System.out.println();
                    System.out.format("|%-25s|", "FT One Prob");
                    System.out.format("|%-25s|", Double.toString(FTtotalHomeOneRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(FTtotalAwayOneRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(FTtotalMinOne).substring(0, 3));
                    System.out.println();
                    System.out.format("|%-25s|", "FT Two Prob");
                    System.out.format("|%-25s|", Double.toString(FTtotalHomeTwoRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(FTtotalAwayTwoRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(FTtotalMinTwo).substring(0, 3));
                    System.out.println();
                    System.out.format("|%-25s|", "FT Three Prob");
                    System.out.format("|%-25s|", Double.toString(FTtotalHomeThreeRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(FTtotalAwayThreeRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(FTtotalMinThree).substring(0, 3));
                    System.out.println();
                    System.out.format("|%-25s|", "FT Four Prob");
                    System.out.format("|%-25s|", Double.toString(FTtotalHomeFourRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(FTtotalAwayFourRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(FTtotalMinFour).substring(0, 3));
                    System.out.println();
                    System.out.format("|%-25s|", "HT One Prob");
                    System.out.format("|%-25s|", Double.toString(HTtotalHomeOneRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(HTtotalAwayOneRecProb).substring(0, 3));
                    System.out.format("|%-25s|", Double.toString(HTtotalOneAvg).substring(0, 3));
                    System.out.println();

                    System.out.format("|%-25s|", "BetThis -> " + betThis);
                    System.out.format("|%-25s|", "HT BetThis -> " + htBetThis);
                    if(tier == 1)
                        System.out.format("|%-25s|", "Tier -> 1 (100% Max Bet)");
                    if(tier == 2)
                        System.out.format("|%-25s|", "Tier -> 2 (20% Max Bet)");
                    if(tier == 3)
                        System.out.format("|%-25s|", "Tier -> 3 (10% Max Bet)");
                    if(tier == 4)
                        System.out.format("|%-25s|", "Tier -> 4 (5% Max Bet)");

                    System.out.println();

                } else
                    continue;

            } catch (Exception e) {
                // System.out.println(e);

//				myWriter.close();
//
//				driver.close();
//				driver.quit();

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
                                         int startIndex, int endIndex, String day) {
        driver.get("https://www.goaloo.mobi/football/schedule-" + day + "");
	//	driver.get("https://www.goaloo.mobi/football/");
//
        driver.findElement(By.xpath("//*[@id='fHead']/div[1]/span[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='displayZone']")));
        driver.findElement(By.xpath("//*[@id='displayZone']")).click();
        driver.findElement(By.xpath("//*[@id='setting_popSel']/ul/li[8]")).click();
        driver.navigate().refresh();

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
//				 league =
//				 driver.findElement(By.xpath("//*[@id='gameList']/div["+h+"]/div[2]/div[1]/span[2]")).getText();
//
////				// System.out.println(postponedCanceledFT);
//////	 				if (postponedCanceledFT.equals("Postp.") || postponedCanceledFT.equals("Canceled")) {
//////	 					i++;
//////	 					continue;
////
//	 			if (
//	 						league.contains("Youth") ||
//	 						league.contains("RUS YthC") ||
//	 						league.contains("U17") ||
//	 						league.contains("U18") ||
//	 						league.contains("U19") ||
//	 						league.contains("U20") ||
//							league.contains("Finland K")
//
//
//
//	 						)
//	 				{
//	 					i++;
//	 					continue;
//	 				}
//	 				else {

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

        driver.get("http://www.goaloo.mobi/football/database/schedule-" + schedule + "?round=" + week);

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
                    links.add("https://www.goaloo.mobi/football/match/h2h-" + scheduleSplit[1]);
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
}
