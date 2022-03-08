package com.jay.currency

import org.json.JSONObject
import org.junit.Test

class ViewModelTest {

    @Test
    fun `rateResponseParsingTest`() {
        val sampleJson = JSONObject(rateResponseSample)
        val quotes = sampleJson["quotes"]
        val keys = JSONObject(quotes.toString()).keys()

        while(keys.hasNext()) {
            val key = keys.next()
            
        }

    }


    val rateResponseSample = "{\n" +
            "    \"success\": true,\n" +
            "    \"terms\": \"https://currencylayer.com/terms\",\n" +
            "    \"privacy\": \"https://currencylayer.com/privacy\",\n" +
            "    \"timestamp\": 1430401802,\n" +
            "    \"source\": \"USD\",\n" +
            "    \"quotes\": {\n" +
            "        \"USDAED\": 3.672982,\n" +
            "        \"USDAFN\": 57.8936,\n" +
            "        \"USDALL\": 126.1652,\n" +
            "        \"USDAMD\": 475.306,\n" +
            "        \"USDANG\": 1.78952,\n" +
            "        \"USDAOA\": 109.216875,\n" +
            "        \"USDARS\": 8.901966,\n" +
            "        \"USDAUD\": 1.269072,\n" +
            "        \"USDAWG\": 1.792375,\n" +
            "        \"USDAZN\": 1.04945,\n" +
            "        \"USDBAM\": 1.757305\n" +
            "    }\n" +
            "}              "


    val supportCurrencyResponseSample = "{\n" +
            "    \"success\": true,\n" +
            "    \"terms\": \"https://currencylayer.com/terms\",\n" +
            "    \"privacy\": \"https://currencylayer.com/privacy\",\n" +
            "    \"currencies\": {\n" +
            "        \"AED\": \"United Arab Emirates Dirham\",\n" +
            "        \"AFN\": \"Afghan Afghani\",\n" +
            "        \"ALL\": \"Albanian Lek\",\n" +
            "        \"AMD\": \"Armenian Dram\",\n" +
            "        \"ANG\": \"Netherlands Antillean Guilder\"  \n" +
            "    }\n" +
            "}     " +
            "                  "

    val currencyRateSample2 = "{\n" +
            "    \"success\": true,\n" +
            "    \"terms\": \"https://currencylayer.com/terms\",\n" +
            "    \"privacy\": \"https://currencylayer.com/privacy\",\n" +
            "    \"timestamp\": 1646554262,\n" +
            "    \"source\": \"USD\",\n" +
            "    \"quotes\": {\n" +
            "        \"USDAED\": 3.673104,\n" +
            "        \"USDAFN\": 90.212485,\n" +
            "        \"USDALL\": 112.861733,\n" +
            "        \"USDAMD\": 505.616537,\n" +
            "        \"USDANG\": 1.810933,\n" +
            "        \"USDAOA\": 476.229041,\n" +
            "        \"USDARS\": 108.558742,\n" +
            "        \"USDAUD\": 1.356668,\n" +
            "        \"USDAWG\": 1.80025,\n" +
            "        \"USDAZN\": 1.70397,\n" +
            "        \"USDBAM\": 1.790545,\n" +
            "        \"USDBBD\": 2.02882,\n" +
            "        \"USDBDT\": 86.558669,\n" +
            "        \"USDBGN\": 1.791397,\n" +
            "        \"USDBHD\": 0.377091,\n" +
            "        \"USDBIF\": 2009.099981,\n" +
            "        \"USDBMD\": 1,\n" +
            "        \"USDBND\": 1.366279,\n" +
            "        \"USDBOB\": 6.908021,\n" +
            "        \"USDBRL\": 5.064146,\n" +
            "        \"USDBSD\": 1.004843,\n" +
            "        \"USDBTC\": 0.000025444607,\n" +
            "        \"USDBTN\": 76.548965,\n" +
            "        \"USDBWP\": 11.745201,\n" +
            "        \"USDBYN\": 3.112212,\n" +
            "        \"USDBYR\": 19600,\n" +
            "        \"USDBZD\": 2.025341,\n" +
            "        \"USDCAD\": 1.27362,\n" +
            "        \"USDCDF\": 2016.000362,\n" +
            "        \"USDCHF\": 0.916356,\n" +
            "        \"USDCLF\": 0.029178,\n" +
            "        \"USDCLP\": 805.122538,\n" +
            "        \"USDCNY\": 6.317704,\n" +
            "        \"USDCOP\": 3777.499062,\n" +
            "        \"USDCRC\": 646.528916,\n" +
            "        \"USDCUC\": 1,\n" +
            "        \"USDCUP\": 26.5,\n" +
            "        \"USDCVE\": 100.946618,\n" +
            "        \"USDCZK\": 23.54315,\n" +
            "        \"USDDJF\": 178.877791,\n" +
            "        \"USDDKK\": 6.802325,\n" +
            "        \"USDDOP\": 55.093334,\n" +
            "        \"USDDZD\": 142.670121,\n" +
            "        \"USDEGP\": 15.695178,\n" +
            "        \"USDERN\": 15.000019,\n" +
            "        \"USDETB\": 51.522462,\n" +
            "        \"USDEUR\": 0.913435,\n" +
            "        \"USDFJD\": 2.109304,\n" +
            "        \"USDFKP\": 0.72792,\n" +
            "        \"USDGBP\": 0.756001,\n" +
            "        \"USDGEL\": 3.350391,\n" +
            "        \"USDGGP\": 0.72792,\n" +
            "        \"USDGHS\": 7.083886,\n" +
            "        \"USDGIP\": 0.72792,\n" +
            "        \"USDGMD\": 53.25039,\n" +
            "        \"USDGNF\": 9016.579542,\n" +
            "        \"USDGTQ\": 7.746977,\n" +
            "        \"USDGYD\": 210.224204,\n" +
            "        \"USDHKD\": 7.81428,\n" +
            "        \"USDHNL\": 24.74206,\n" +
            "        \"USDHRK\": 6.918104,\n" +
            "        \"USDHTG\": 105.138651,\n" +
            "        \"USDHUF\": 354.59504,\n" +
            "        \"USDIDR\": 14383.2,\n" +
            "        \"USDILS\": 3.282075,\n" +
            "        \"USDIMP\": 0.72792,\n" +
            "        \"USDINR\": 76.425504,\n" +
            "        \"USDIQD\": 1466.525071,\n" +
            "        \"USDIRR\": 42325.000352,\n" +
            "        \"USDISK\": 131.720386,\n" +
            "        \"USDJEP\": 0.72792,\n" +
            "        \"USDJMD\": 155.116222,\n" +
            "        \"USDJOD\": 0.70904,\n" +
            "        \"USDJPY\": 114.81504,\n" +
            "        \"USDKES\": 114.547427,\n" +
            "        \"USDKGS\": 97.673704,\n" +
            "        \"USDKHR\": 4084.554751,\n" +
            "        \"USDKMF\": 450.950384,\n" +
            "        \"USDKPW\": 900.000157,\n" +
            "        \"USDKRW\": 1216.925039,\n" +
            "        \"USDKWD\": 0.30342,\n" +
            "        \"USDKYD\": 0.8374,\n" +
            "        \"USDKZT\": 512.766522,\n" +
            "        \"USDLAK\": 11519.074255,\n" +
            "        \"USDLBP\": 1519.440452,\n" +
            "        \"USDLKR\": 202.467615,\n" +
            "        \"USDLRD\": 154.250382,\n" +
            "        \"USDLSL\": 15.310382,\n" +
            "        \"USDLTL\": 2.95274,\n" +
            "        \"USDLVL\": 0.60489,\n" +
            "        \"USDLYD\": 4.646025,\n" +
            "        \"USDMAD\": 9.738536,\n" +
            "        \"USDMDL\": 18.463257,\n" +
            "        \"USDMGA\": 4018.199962,\n" +
            "        \"USDMKD\": 56.407979,\n" +
            "        \"USDMMK\": 1786.688394,\n" +
            "        \"USDMNT\": 2858.831164,\n" +
            "        \"USDMOP\": 8.087905,\n" +
            "        \"USDMRO\": 356.999828,\n" +
            "        \"USDMUR\": 44.263991,\n" +
            "        \"USDMVR\": 15.450378,\n" +
            "        \"USDMWK\": 807.508857,\n" +
            "        \"USDMXN\": 20.94825,\n" +
            "        \"USDMYR\": 4.178039,\n" +
            "        \"USDMZN\": 63.830377,\n" +
            "        \"USDNAD\": 15.310377,\n" +
            "        \"USDNGN\": 418.490377,\n" +
            "        \"USDNIO\": 35.926614,\n" +
            "        \"USDNOK\": 8.941795,\n" +
            "        \"USDNPR\": 122.478051,\n" +
            "        \"USDNZD\": 1.457195,\n" +
            "        \"USDOMR\": 0.385165,\n" +
            "        \"USDPAB\": 1.004843,\n" +
            "        \"USDPEN\": 3.748386,\n" +
            "        \"USDPGK\": 3.540478,\n" +
            "        \"USDPHP\": 51.950375,\n" +
            "        \"USDPKR\": 179.080847,\n" +
            "        \"USDPLN\": 4.483221,\n" +
            "        \"USDPYG\": 6997.280992,\n" +
            "        \"USDQAR\": 3.641038,\n" +
            "        \"USDRON\": 4.527504,\n" +
            "        \"USDRSD\": 107.668153,\n" +
            "        \"USDRUB\": 124.000341,\n" +
            "        \"USDRWF\": 1034.944292,\n" +
            "        \"USDSAR\": 3.752127,\n" +
            "        \"USDSBD\": 8.058065,\n" +
            "        \"USDSCR\": 14.405251,\n" +
            "        \"USDSDG\": 446.00034,\n" +
            "        \"USDSEK\": 9.82735,\n" +
            "        \"USDSGD\": 1.36025,\n" +
            "        \"USDSHP\": 1.377404,\n" +
            "        \"USDSLL\": 11625.000339,\n" +
            "        \"USDSOS\": 584.000338,\n" +
            "        \"USDSRD\": 20.470504,\n" +
            "        \"USDSTD\": 20697.981008,\n" +
            "        \"USDSVC\": 8.792376,\n" +
            "        \"USDSYP\": 2511.999776,\n" +
            "        \"USDSZL\": 15.422545,\n" +
            "        \"USDTHB\": 32.684038,\n" +
            "        \"USDTJS\": 11.33918,\n" +
            "        \"USDTMT\": 3.51,\n" +
            "        \"USDTND\": 2.947504,\n" +
            "        \"USDTOP\": 2.273104,\n" +
            "        \"USDTRY\": 14.186504,\n" +
            "        \"USDTTD\": 6.819676,\n" +
            "        \"USDTWD\": 28.137038,\n" +
            "        \"USDTZS\": 2326.116212,\n" +
            "        \"USDUAH\": 30.194267,\n" +
            "        \"USDUGX\": 3597.14733,\n" +
            "        \"USDUSD\": 1,\n" +
            "        \"USDUYU\": 42.940191,\n" +
            "        \"USDUZS\": 10952.58672,\n" +
            "        \"USDVEF\": 213830222338.07285,\n" +
            "        \"USDVND\": 22840,\n" +
            "        \"USDVUV\": 113.671414,\n" +
            "        \"USDWST\": 2.612343,\n" +
            "        \"USDXAF\": 600.522745,\n" +
            "        \"USDXAG\": 0.044408,\n" +
            "        \"USDXAU\": 0.000553,\n" +
            "        \"USDXCD\": 2.70255,\n" +
            "        \"USDXDR\": 0.723055,\n" +
            "        \"USDXOF\": 600.522745,\n" +
            "        \"USDXPF\": 109.625037,\n" +
            "        \"USDYER\": 250.250364,\n" +
            "        \"USDZAR\": 15.45954,\n" +
            "        \"USDZMK\": 9001.203593,\n" +
            "        \"USDZMW\": 18.071335,\n" +
            "        \"USDZWL\": 321.999592\n" +
            "    }\n" +
            "}"

    val supportSample2 = "{\n" +
            "    \"success\": true,\n" +
            "    \"terms\": \"https://currencylayer.com/terms\",\n" +
            "    \"privacy\": \"https://currencylayer.com/privacy\",\n" +
            "    \"currencies\": {\n" +
            "        \"AED\": \"United Arab Emirates Dirham\",\n" +
            "        \"AFN\": \"Afghan Afghani\",\n" +
            "        \"ALL\": \"Albanian Lek\",\n" +
            "        \"AMD\": \"Armenian Dram\",\n" +
            "        \"ANG\": \"Netherlands Antillean Guilder\",\n" +
            "        \"AOA\": \"Angolan Kwanza\",\n" +
            "        \"ARS\": \"Argentine Peso\",\n" +
            "        \"AUD\": \"Australian Dollar\",\n" +
            "        \"AWG\": \"Aruban Florin\",\n" +
            "        \"AZN\": \"Azerbaijani Manat\",\n" +
            "        \"BAM\": \"Bosnia-Herzegovina Convertible Mark\",\n" +
            "        \"BBD\": \"Barbadian Dollar\",\n" +
            "        \"BDT\": \"Bangladeshi Taka\",\n" +
            "        \"BGN\": \"Bulgarian Lev\",\n" +
            "        \"BHD\": \"Bahraini Dinar\",\n" +
            "        \"BIF\": \"Burundian Franc\",\n" +
            "        \"BMD\": \"Bermudan Dollar\",\n" +
            "        \"BND\": \"Brunei Dollar\",\n" +
            "        \"BOB\": \"Bolivian Boliviano\",\n" +
            "        \"BRL\": \"Brazilian Real\",\n" +
            "        \"BSD\": \"Bahamian Dollar\",\n" +
            "        \"BTC\": \"Bitcoin\",\n" +
            "        \"BTN\": \"Bhutanese Ngultrum\",\n" +
            "        \"BWP\": \"Botswanan Pula\",\n" +
            "        \"BYN\": \"New Belarusian Ruble\",\n" +
            "        \"BYR\": \"Belarusian Ruble\",\n" +
            "        \"BZD\": \"Belize Dollar\",\n" +
            "        \"CAD\": \"Canadian Dollar\",\n" +
            "        \"CDF\": \"Congolese Franc\",\n" +
            "        \"CHF\": \"Swiss Franc\",\n" +
            "        \"CLF\": \"Chilean Unit of Account (UF)\",\n" +
            "        \"CLP\": \"Chilean Peso\",\n" +
            "        \"CNY\": \"Chinese Yuan\",\n" +
            "        \"COP\": \"Colombian Peso\",\n" +
            "        \"CRC\": \"Costa Rican Colón\",\n" +
            "        \"CUC\": \"Cuban Convertible Peso\",\n" +
            "        \"CUP\": \"Cuban Peso\",\n" +
            "        \"CVE\": \"Cape Verdean Escudo\",\n" +
            "        \"CZK\": \"Czech Republic Koruna\",\n" +
            "        \"DJF\": \"Djiboutian Franc\",\n" +
            "        \"DKK\": \"Danish Krone\",\n" +
            "        \"DOP\": \"Dominican Peso\",\n" +
            "        \"DZD\": \"Algerian Dinar\",\n" +
            "        \"EGP\": \"Egyptian Pound\",\n" +
            "        \"ERN\": \"Eritrean Nakfa\",\n" +
            "        \"ETB\": \"Ethiopian Birr\",\n" +
            "        \"EUR\": \"Euro\",\n" +
            "        \"FJD\": \"Fijian Dollar\",\n" +
            "        \"FKP\": \"Falkland Islands Pound\",\n" +
            "        \"GBP\": \"British Pound Sterling\",\n" +
            "        \"GEL\": \"Georgian Lari\",\n" +
            "        \"GGP\": \"Guernsey Pound\",\n" +
            "        \"GHS\": \"Ghanaian Cedi\",\n" +
            "        \"GIP\": \"Gibraltar Pound\",\n" +
            "        \"GMD\": \"Gambian Dalasi\",\n" +
            "        \"GNF\": \"Guinean Franc\",\n" +
            "        \"GTQ\": \"Guatemalan Quetzal\",\n" +
            "        \"GYD\": \"Guyanaese Dollar\",\n" +
            "        \"HKD\": \"Hong Kong Dollar\",\n" +
            "        \"HNL\": \"Honduran Lempira\",\n" +
            "        \"HRK\": \"Croatian Kuna\",\n" +
            "        \"HTG\": \"Haitian Gourde\",\n" +
            "        \"HUF\": \"Hungarian Forint\",\n" +
            "        \"IDR\": \"Indonesian Rupiah\",\n" +
            "        \"ILS\": \"Israeli New Sheqel\",\n" +
            "        \"IMP\": \"Manx pound\",\n" +
            "        \"INR\": \"Indian Rupee\",\n" +
            "        \"IQD\": \"Iraqi Dinar\",\n" +
            "        \"IRR\": \"Iranian Rial\",\n" +
            "        \"ISK\": \"Icelandic Króna\",\n" +
            "        \"JEP\": \"Jersey Pound\",\n" +
            "        \"JMD\": \"Jamaican Dollar\",\n" +
            "        \"JOD\": \"Jordanian Dinar\",\n" +
            "        \"JPY\": \"Japanese Yen\",\n" +
            "        \"KES\": \"Kenyan Shilling\",\n" +
            "        \"KGS\": \"Kyrgystani Som\",\n" +
            "        \"KHR\": \"Cambodian Riel\",\n" +
            "        \"KMF\": \"Comorian Franc\",\n" +
            "        \"KPW\": \"North Korean Won\",\n" +
            "        \"KRW\": \"South Korean Won\",\n" +
            "        \"KWD\": \"Kuwaiti Dinar\",\n" +
            "        \"KYD\": \"Cayman Islands Dollar\",\n" +
            "        \"KZT\": \"Kazakhstani Tenge\",\n" +
            "        \"LAK\": \"Laotian Kip\",\n" +
            "        \"LBP\": \"Lebanese Pound\",\n" +
            "        \"LKR\": \"Sri Lankan Rupee\",\n" +
            "        \"LRD\": \"Liberian Dollar\",\n" +
            "        \"LSL\": \"Lesotho Loti\",\n" +
            "        \"LTL\": \"Lithuanian Litas\",\n" +
            "        \"LVL\": \"Latvian Lats\",\n" +
            "        \"LYD\": \"Libyan Dinar\",\n" +
            "        \"MAD\": \"Moroccan Dirham\",\n" +
            "        \"MDL\": \"Moldovan Leu\",\n" +
            "        \"MGA\": \"Malagasy Ariary\",\n" +
            "        \"MKD\": \"Macedonian Denar\",\n" +
            "        \"MMK\": \"Myanma Kyat\",\n" +
            "        \"MNT\": \"Mongolian Tugrik\",\n" +
            "        \"MOP\": \"Macanese Pataca\",\n" +
            "        \"MRO\": \"Mauritanian Ouguiya\",\n" +
            "        \"MUR\": \"Mauritian Rupee\",\n" +
            "        \"MVR\": \"Maldivian Rufiyaa\",\n" +
            "        \"MWK\": \"Malawian Kwacha\",\n" +
            "        \"MXN\": \"Mexican Peso\",\n" +
            "        \"MYR\": \"Malaysian Ringgit\",\n" +
            "        \"MZN\": \"Mozambican Metical\",\n" +
            "        \"NAD\": \"Namibian Dollar\",\n" +
            "        \"NGN\": \"Nigerian Naira\",\n" +
            "        \"NIO\": \"Nicaraguan Córdoba\",\n" +
            "        \"NOK\": \"Norwegian Krone\",\n" +
            "        \"NPR\": \"Nepalese Rupee\",\n" +
            "        \"NZD\": \"New Zealand Dollar\",\n" +
            "        \"OMR\": \"Omani Rial\",\n" +
            "        \"PAB\": \"Panamanian Balboa\",\n" +
            "        \"PEN\": \"Peruvian Nuevo Sol\",\n" +
            "        \"PGK\": \"Papua New Guinean Kina\",\n" +
            "        \"PHP\": \"Philippine Peso\",\n" +
            "        \"PKR\": \"Pakistani Rupee\",\n" +
            "        \"PLN\": \"Polish Zloty\",\n" +
            "        \"PYG\": \"Paraguayan Guarani\",\n" +
            "        \"QAR\": \"Qatari Rial\",\n" +
            "        \"RON\": \"Romanian Leu\",\n" +
            "        \"RSD\": \"Serbian Dinar\",\n" +
            "        \"RUB\": \"Russian Ruble\",\n" +
            "        \"RWF\": \"Rwandan Franc\",\n" +
            "        \"SAR\": \"Saudi Riyal\",\n" +
            "        \"SBD\": \"Solomon Islands Dollar\",\n" +
            "        \"SCR\": \"Seychellois Rupee\",\n" +
            "        \"SDG\": \"Sudanese Pound\",\n" +
            "        \"SEK\": \"Swedish Krona\",\n" +
            "        \"SGD\": \"Singapore Dollar\",\n" +
            "        \"SHP\": \"Saint Helena Pound\",\n" +
            "        \"SLL\": \"Sierra Leonean Leone\",\n" +
            "        \"SOS\": \"Somali Shilling\",\n" +
            "        \"SRD\": \"Surinamese Dollar\",\n" +
            "        \"STD\": \"São Tomé and Príncipe Dobra\",\n" +
            "        \"SVC\": \"Salvadoran Colón\",\n" +
            "        \"SYP\": \"Syrian Pound\",\n" +
            "        \"SZL\": \"Swazi Lilangeni\",\n" +
            "        \"THB\": \"Thai Baht\",\n" +
            "        \"TJS\": \"Tajikistani Somoni\",\n" +
            "        \"TMT\": \"Turkmenistani Manat\",\n" +
            "        \"TND\": \"Tunisian Dinar\",\n" +
            "        \"TOP\": \"Tongan Paʻanga\",\n" +
            "        \"TRY\": \"Turkish Lira\",\n" +
            "        \"TTD\": \"Trinidad and Tobago Dollar\",\n" +
            "        \"TWD\": \"New Taiwan Dollar\",\n" +
            "        \"TZS\": \"Tanzanian Shilling\",\n" +
            "        \"UAH\": \"Ukrainian Hryvnia\",\n" +
            "        \"UGX\": \"Ugandan Shilling\",\n" +
            "        \"USD\": \"United States Dollar\",\n" +
            "        \"UYU\": \"Uruguayan Peso\",\n" +
            "        \"UZS\": \"Uzbekistan Som\",\n" +
            "        \"VEF\": \"Venezuelan Bolívar Fuerte\",\n" +
            "        \"VND\": \"Vietnamese Dong\",\n" +
            "        \"VUV\": \"Vanuatu Vatu\",\n" +
            "        \"WST\": \"Samoan Tala\",\n" +
            "        \"XAF\": \"CFA Franc BEAC\",\n" +
            "        \"XAG\": \"Silver (troy ounce)\",\n" +
            "        \"XAU\": \"Gold (troy ounce)\",\n" +
            "        \"XCD\": \"East Caribbean Dollar\",\n" +
            "        \"XDR\": \"Special Drawing Rights\",\n" +
            "        \"XOF\": \"CFA Franc BCEAO\",\n" +
            "        \"XPF\": \"CFP Franc\",\n" +
            "        \"YER\": \"Yemeni Rial\",\n" +
            "        \"ZAR\": \"South African Rand\",\n" +
            "        \"ZMK\": \"Zambian Kwacha (pre-2013)\",\n" +
            "        \"ZMW\": \"Zambian Kwacha\",\n" +
            "        \"ZWL\": \"Zimbabwean Dollar\"\n" +
            "    }\n" +
            "}"
}