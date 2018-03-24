
import java.io.FileNotFoundException;
import java.util.Calendar;

/**
 * Klasa odpowiadająca za wykonanie programu. Interpretuje argumenty podane przy uruchomieniu programu.
 * @author Karolina Piekarz
 */
public class Main {

    /**
     * W zalezności od pierwszego argumentu wykonywane są inne funckcje.
     * @param args argumenty podane przy uruchomieniu programu
     */
    public static void main(String[] args){
        if(args.length==0){
            System.out.println("------------------------------------------------------------\n" +
                    "|Program arguments:                                        |\n" +
                    "| date - RRRR-MM-DD                                        |\n" +
                    "| currency - 3 letters, ISO 4217                           |\n" +
                    "| number - number of week in month                         |\n" +
                    "------------------------------------------------------------\n" +
                    "Functions : FUNCTION_NAME arg1 arg2 ...\n" +
                    "------------------------------------------------------------\n" +
                    "| printPriceGold date                                      |\n" +
                    "| printPriceCurr date currency                             |\n" +
                    "| averageGoldPrice date date                               |\n" +
                    "| highestAmplitude date                                    |\n" +
                    "| lowestPriceCurrency date                                 |\n" +
                    "| printNSorted date number                                 |\n" +
                    "| currencyPeak currency                                    |\n" +
                    "| createGraph currency year month number year month number |\n" +
                    "------------------------------------------------------------\n");
        }
        else {
            DateChecker checker = new DateChecker();
            DateFormater formater = new DateFormater();
            try {
                if (args[0].equalsIgnoreCase("printPriceGold") && args.length>=2) {
                    GoldPrice gp = new GoldPrice();
                    Calendar cal = Calendar.getInstance();

                    String dateStr = args[1];
                    checker.checkDate(dateStr, "gold");

                    int year = Integer.parseInt(dateStr.substring(0, 4));
                    int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
                    int day = Integer.parseInt(dateStr.substring(8, 10));

                    cal.set(year, month, day);
                    System.out.println("In " + dateStr.substring(0, 10) + ":");

                    try {
                        System.out.println("Gold price: " + gp.getgoldPrice(cal, "Cena"));
                    } catch (FileNotFoundException e) {
                        System.out.println("No data for gold.");
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                else if(args[0].equalsIgnoreCase("printPriceCurr") && args.length>=3){
                    Calendar cal = Calendar.getInstance();

                    String dateStr = args[1];
                    checker.checkDate(dateStr, " ");

                    int year = Integer.parseInt(dateStr.substring(0, 4));
                    int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
                    int day = Integer.parseInt(dateStr.substring(8, 10));

                    cal.set(year, month, day);
                    System.out.println("In " + dateStr.substring(0, 10) + ":");
                    CurrencyPrice cp = new CurrencyPrice();

                    CurrencyChecker checker1 = new CurrencyChecker();
                    checker1.checkCurrency(args[2]);

                    try {
                        System.out.println(args[2] + " price: " + cp.getcurrencyPrice(cal, args[2], "Mid"));
                    } catch (FileNotFoundException e) {
                        System.out.println("No data for currency " + args[2]);
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                else if (args[0].equalsIgnoreCase("averageGoldPrice") && args.length>=3) {

                    AverageCalculator calc = new AverageCalculator();
                    Calendar cal1 = Calendar.getInstance();
                    Calendar cal2 = Calendar.getInstance();
                    String dateStr1 = args[1];
                    String dateStr2 = args[2];
                    checker.checkDate(dateStr1, "gold");
                    checker.checkDate(dateStr2, "gold");


                    int year1 = Integer.parseInt(dateStr1.substring(0, 4));
                    int month1 = Integer.parseInt(dateStr1.substring(5, 7)) - 1;
                    int day1 = Integer.parseInt(dateStr1.substring(8, 10));

                    int year2 = Integer.parseInt(dateStr2.substring(0, 4));
                    int month2 = Integer.parseInt(dateStr2.substring(5, 7)) - 1;
                    int day2 = Integer.parseInt(dateStr2.substring(8, 10));

                    cal1.set(year1, month1, day1);
                    cal2.set(year2, month2, day2);

                    checker.checkDate(cal1, cal2);

                    GoldRecord gold = new GoldRecord();

                    try {
                        System.out.println("Average gold price from " + args[1].substring(0, 10) + " to " + args[2].substring(0, 10) + ": " + calc.computeAverage(cal1, cal2, gold, "Cena"));
                    } catch (FileNotFoundException e) {
                        System.out.println("No data");
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (args[0].equalsIgnoreCase("highestAmplitude") && args.length>=2) {

                    Calendar cal = Calendar.getInstance();

                    String dateStr = args[1];
                    checker.checkDate(dateStr, "");

                    int year = Integer.parseInt(dateStr.substring(0, 4));
                    int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
                    int day = Integer.parseInt(dateStr.substring(8, 10));

                    cal.set(year, month, day);

                    TableA table = new TableA();

                    HighestAmplitudeFinder finder = new HighestAmplitudeFinder();

                    try {
                        System.out.println(finder.getHighestAmplitudeCurrency(cal, table, "Currency", "Mid"));
                    } catch (FileNotFoundException e) {
                        System.out.println("No data for day " + args[1].substring(0, 10));
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (args[0].equalsIgnoreCase("lowestPriceCurrency") && args.length>=2) {

                    LowestAsk finder = new LowestAsk();

                    Calendar cal = Calendar.getInstance();

                    String dateStr = args[1];
                    checker.checkDate(dateStr, "");

                    int year = Integer.parseInt(dateStr.substring(0, 4));
                    int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
                    int day = Integer.parseInt(dateStr.substring(8, 10));

                    cal.set(year, month, day);

                    TableC table = new TableC();

                    try {
                        System.out.println(finder.findLowestAsk(cal, table, "Currency", "Ask"));
                    } catch (FileNotFoundException e) {
                        System.out.println("No data for day " + args[1].substring(0, 10));
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } else if (args[0].equalsIgnoreCase("printNSorted") && args.length>=3) {

                    Calendar cal = Calendar.getInstance();

                    String dateStr = args[1];
                    checker.checkDate(dateStr, "");

                    int year = Integer.parseInt(dateStr.substring(0, 4));
                    int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
                    int day = Integer.parseInt(dateStr.substring(8, 10));

                    cal.set(year, month, day);

                    PrinterNSorted printer = new PrinterNSorted();
                    IntegerChecker checker2 = new IntegerChecker();
                    checker2.checkInteger(args[2]);

                    TableC table = new TableC();

                    try {
                        printer.printNSorted(Integer.parseInt(args[2]), table, cal);
                    } catch (FileNotFoundException e) {
                        System.out.println("No data for day " + args[1].substring(0, 10));
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (args[0].equalsIgnoreCase("currencyPeak") && args.length>=2) {
                    String currencyName = args[1];
                    Currency tab = new Currency(args[1]);
                    CurrencyPeak checker2 = new CurrencyPeak();
                    try {
                        DoubleDate DD = checker2.compute(tab, "Rate", "Mid", "EffectiveDate");
                        if (DD.getFirstDate() == null) {
                        throw new NonExistentCurrencyException();
                        } else {
                            System.out.println(currencyName + " was the most expensive in " + DD.getFirstDate() + " with price " + DD.getHighest() + " and the cheapest in " + DD.getSecondDate() + " with price " + DD.getLowest());
                        }
                    }
                    catch(NonExistentCurrencyException e){
                        System.out.println("Currency doesn't exist in the database");
                        e.printStackTrace();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (args[0].equalsIgnoreCase("createGraph") && args.length>=8) {
                    String currencyName = args[1];

                    if(args[2].length()<4 || args[3].length()<2) throw new WrongDateFormatException();
                    if(args[5].length()<4 || args[6].length()<2) throw new WrongDateFormatException();

                    int year1 = Integer.parseInt(args[2]);
                    int month1 = Integer.parseInt(args[3]) - 1;
                    int number1 = Integer.parseInt(args[4]);

                    int year2 = Integer.parseInt(args[5]);
                    int month2 = Integer.parseInt(args[6]) - 1;
                    int number2 = Integer.parseInt(args[7]);

                    WeekChecker checker2 = new WeekChecker();
                    checker2.checkWeek(number1);
                    checker2.checkWeek(number2);

                    CalendarConverter conv = new CalendarConverter();
                    Calendar cal1 = conv.convertFirst(year1, month1, number1);
                    Calendar cal2 = conv.convertLast(year2, month2, number2);

                    checker.checkDate(formater.format(cal1), "");
                    checker.checkDate(formater.format(cal2), "");
                    checker.checkDate(cal1, cal2);

                    GraphCreator creator = new GraphCreator();

                    Currency tab = new Currency(currencyName);

                    try {
                        creator.create(cal1, cal2, tab, "Rate", "Mid", "EffectiveDate");
                    } catch (FileNotFoundException e) {
                        System.out.println("No data");
                        e.printStackTrace();
                    }
                    catch(NonExistentCurrencyException e){
                        System.out.println("Currency doesn't exist in the database");
                        e.printStackTrace();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println("------------------------------------------------------------\n" +
                            "|Program arguments:                                        |\n" +
                            "| date - RRRR-MM-DD                                        |\n" +
                            "| currency - 3 letters, ISO 4217                           |\n" +
                            "| number - number of week in month                         |\n" +
                            "------------------------------------------------------------\n" +
                            "Functions : FUNCTION_NAME arg1 arg2 ...\n" +
                            "------------------------------------------------------------\n" +
                            "| printPriceGold date                                      |\n" +
                            "| printPriceCurr date currency                             |\n" +
                            "| averageGoldPrice date date                               |\n" +
                            "| highestAmplitude date                                    |\n" +
                            "| lowestPriceCurrency date                                 |\n" +
                            "| printNSorted date number                                 |\n" +
                            "| currencyPeak currency                                    |\n" +
                            "| createGraph currency year month number year month number |\n" +
                            "------------------------------------------------------------\n");
                }
            } catch (WrongGoldDateException e) {
                System.out.println("Date must be after 2013.01.01");
                e.printStackTrace();
            } catch (WrongCurrencyDateException e) {
                System.out.println("Dae must be after 2002.01.01");
                e.printStackTrace();
            } catch (WrongDateFormatException e) {
                System.out.println("Wrong date");
                e.printStackTrace();
            } catch (WrongCurrencyNameException e) {
                System.out.println("Wrong currency name");
                e.printStackTrace();
            } catch (WrongIntegerException e) {
                System.out.println("This is not a number");
                e.printStackTrace();
            } catch (WrongWeekException e) {
                System.out.println("Week must be a number from 1 to 5");
                e.printStackTrace();
            }

        }

    }
}
