package com.hczh.carownercoming.other.bean;

import java.util.List;

/**
 * Created by LiuTao008
 * on 2016/4/13.
 */
public class Weather {


    /**
     * realtime : {"wind":{"windspeed":"4.0","direct":"东南风","power":"1级","offset":null},"time":"14:00:00","weather":{"humidity":"70","img":"1","info":"多云","temperature":"19"},"dataUptime":"1460530215","date":"2016-04-13","city_code":"101260101","city_name":"贵阳","week":"3","moon":"三月初七"}
     * life : {"date":"2016-4-13","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较适宜","天气较好，但考虑气温较低，推荐您进行室内运动，若户外运动请适当增减衣物并注意防晒。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["中","气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"],"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"]}}
     * weather : [{"date":"2016-04-13","week":"三","nongli":"三月初七","info":{"dawn":null,"day":["1","多云","20","东风","微风","06:31"],"night":["3","阵雨","14","东南风","微风","19:16"]}},{"date":"2016-04-14","week":"四","nongli":"三月初八","info":{"dawn":["3","阵雨","14","东南风","微风","19:16"],"day":["3","阵雨","23","东北风","微风","06:30"],"night":["3","阵雨","16","南风","微风","19:16"]}},{"date":"2016-04-15","week":"五","nongli":"三月初九","info":{"dawn":["3","阵雨","16","南风","微风","19:16"],"day":["1","多云","26","南风","微风","06:29"],"night":["4","雷阵雨","14","东北风","微风","19:17"]}},{"date":"2016-04-16","week":"六","nongli":"三月初十","info":{"dawn":["4","雷阵雨","14","东北风","微风","19:17"],"day":["1","多云","22","东北风","微风","06:28"],"night":["1","多云","13","南风","微风","19:17"]}},{"date":"2016-04-17","week":"日","nongli":"三月十一","info":{"dawn":["1","多云","13","南风","微风","19:17"],"day":["4","雷阵雨","19","东北风","微风","06:27"],"night":["3","阵雨","11","东北风","微风","19:18"]}},{"date":"2016-04-18","week":"一","nongli":"三月十二","info":{"dawn":null,"day":["2","阴","18","东北风","微风","07:30"],"night":["3","阵雨","12","东北风","微风","19:30"]}},{"date":"2016-04-19","week":"二","nongli":"三月十三","info":{"dawn":null,"day":["3","阵雨","21","东南风","微风","07:30"],"night":["4","雷阵雨","13","东南风","微风","19:30"]}}]
     * pm25 : {"key":"","show_desc":"0","pm25":{"curPm":"40","pm25":"17","pm10":"40","level":"1","quality":"优","des":"今天的空气质量令人满意，各类人群可正常活动。"},"dateTime":"2016年04月13日14时","cityName":"贵阳"}
     * isForeign : 0
     */

    private ResultEntity result;
    /**
     * result : {"realtime":{"wind":{"windspeed":"4.0","direct":"东南风","power":"1级","offset":null},"time":"14:00:00","weather":{"humidity":"70","img":"1","info":"多云","temperature":"19"},"dataUptime":"1460530215","date":"2016-04-13","city_code":"101260101","city_name":"贵阳","week":"3","moon":"三月初七"},"life":{"date":"2016-4-13","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较适宜","天气较好，但考虑气温较低，推荐您进行室内运动，若户外运动请适当增减衣物并注意防晒。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["中","气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"],"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"]}},"weather":[{"date":"2016-04-13","week":"三","nongli":"三月初七","info":{"dawn":null,"day":["1","多云","20","东风","微风","06:31"],"night":["3","阵雨","14","东南风","微风","19:16"]}},{"date":"2016-04-14","week":"四","nongli":"三月初八","info":{"dawn":["3","阵雨","14","东南风","微风","19:16"],"day":["3","阵雨","23","东北风","微风","06:30"],"night":["3","阵雨","16","南风","微风","19:16"]}},{"date":"2016-04-15","week":"五","nongli":"三月初九","info":{"dawn":["3","阵雨","16","南风","微风","19:16"],"day":["1","多云","26","南风","微风","06:29"],"night":["4","雷阵雨","14","东北风","微风","19:17"]}},{"date":"2016-04-16","week":"六","nongli":"三月初十","info":{"dawn":["4","雷阵雨","14","东北风","微风","19:17"],"day":["1","多云","22","东北风","微风","06:28"],"night":["1","多云","13","南风","微风","19:17"]}},{"date":"2016-04-17","week":"日","nongli":"三月十一","info":{"dawn":["1","多云","13","南风","微风","19:17"],"day":["4","雷阵雨","19","东北风","微风","06:27"],"night":["3","阵雨","11","东北风","微风","19:18"]}},{"date":"2016-04-18","week":"一","nongli":"三月十二","info":{"dawn":null,"day":["2","阴","18","东北风","微风","07:30"],"night":["3","阵雨","12","东北风","微风","19:30"]}},{"date":"2016-04-19","week":"二","nongli":"三月十三","info":{"dawn":null,"day":["3","阵雨","21","东南风","微风","07:30"],"night":["4","雷阵雨","13","东南风","微风","19:30"]}}],"pm25":{"key":"","show_desc":"0","pm25":{"curPm":"40","pm25":"17","pm10":"40","level":"1","quality":"优","des":"今天的空气质量令人满意，各类人群可正常活动。"},"dateTime":"2016年04月13日14时","cityName":"贵阳"},"isForeign":0}
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public static class ResultEntity {
        /**
         * wind : {"windspeed":"4.0","direct":"东南风","power":"1级","offset":null}
         * time : 14:00:00
         * weather : {"humidity":"70","img":"1","info":"多云","temperature":"19"}
         * dataUptime : 1460530215
         * date : 2016-04-13
         * city_code : 101260101
         * city_name : 贵阳
         * week : 3
         * moon : 三月初七
         */

        private RealtimeEntity realtime;
        /**
         * date : 2016-4-13
         * info : {"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较适宜","天气较好，但考虑气温较低，推荐您进行室内运动，若户外运动请适当增减衣物并注意防晒。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["中","气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"],"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"]}
         */

        private LifeEntity life;
        /**
         * key :
         * show_desc : 0
         * pm25 : {"curPm":"40","pm25":"17","pm10":"40","level":"1","quality":"优","des":"今天的空气质量令人满意，各类人群可正常活动。"}
         * dateTime : 2016年04月13日14时
         * cityName : 贵阳
         */

        private Pm25Entity pm25;
        private int isForeign;
        /**
         * date : 2016-04-13
         * week : 三
         * nongli : 三月初七
         * info : {"dawn":null,"day":["1","多云","20","东风","微风","06:31"],"night":["3","阵雨","14","东南风","微风","19:16"]}
         */

        private List<WeatherEntity> weather;

        public void setRealtime(RealtimeEntity realtime) {
            this.realtime = realtime;
        }

        public void setLife(LifeEntity life) {
            this.life = life;
        }

        public void setPm25(Pm25Entity pm25) {
            this.pm25 = pm25;
        }

        public void setIsForeign(int isForeign) {
            this.isForeign = isForeign;
        }

        public void setWeather(List<WeatherEntity> weather) {
            this.weather = weather;
        }

        public RealtimeEntity getRealtime() {
            return realtime;
        }

        public LifeEntity getLife() {
            return life;
        }

        public Pm25Entity getPm25() {
            return pm25;
        }

        public int getIsForeign() {
            return isForeign;
        }

        public List<WeatherEntity> getWeather() {
            return weather;
        }

        public static class RealtimeEntity {
            /**
             * windspeed : 4.0
             * direct : 东南风
             * power : 1级
             * offset : null
             */

            private WindEntity wind;
            private String time;
            /**
             * humidity : 70
             * img : 1
             * info : 多云
             * temperature : 19
             */

            private WeatherEntity weather;
            private String dataUptime;
            private String date;
            private String city_code;
            private String city_name;
            private String week;
            private String moon;

            public void setWind(WindEntity wind) {
                this.wind = wind;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public void setWeather(WeatherEntity weather) {
                this.weather = weather;
            }

            public void setDataUptime(String dataUptime) {
                this.dataUptime = dataUptime;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setMoon(String moon) {
                this.moon = moon;
            }

            public WindEntity getWind() {
                return wind;
            }

            public String getTime() {
                return time;
            }

            public WeatherEntity getWeather() {
                return weather;
            }

            public String getDataUptime() {
                return dataUptime;
            }

            public String getDate() {
                return date;
            }

            public String getCity_code() {
                return city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public String getWeek() {
                return week;
            }

            public String getMoon() {
                return moon;
            }

            public static class WindEntity {
                private String windspeed;
                private String direct;
                private String power;
                private Object offset;

                public void setWindspeed(String windspeed) {
                    this.windspeed = windspeed;
                }

                public void setDirect(String direct) {
                    this.direct = direct;
                }

                public void setPower(String power) {
                    this.power = power;
                }

                public void setOffset(Object offset) {
                    this.offset = offset;
                }

                public String getWindspeed() {
                    return windspeed;
                }

                public String getDirect() {
                    return direct;
                }

                public String getPower() {
                    return power;
                }

                public Object getOffset() {
                    return offset;
                }
            }

            public static class WeatherEntity {
                private String humidity;
                private String img;
                private String info;
                private String temperature;

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getHumidity() {
                    return humidity;
                }

                public String getImg() {
                    return img;
                }

                public String getInfo() {
                    return info;
                }

                public String getTemperature() {
                    return temperature;
                }
            }
        }

        public static class LifeEntity {
            private String date;
            private InfoEntity info;

            public void setDate(String date) {
                this.date = date;
            }

            public void setInfo(InfoEntity info) {
                this.info = info;
            }

            public String getDate() {
                return date;
            }

            public InfoEntity getInfo() {
                return info;
            }

            public static class InfoEntity {
                private List<String> kongtiao;
                private List<String> yundong;
                private List<String> ziwaixian;
                private List<String> ganmao;
                private List<String> xiche;
                private List<String> wuran;
                private List<String> chuanyi;

                public void setKongtiao(List<String> kongtiao) {
                    this.kongtiao = kongtiao;
                }

                public void setYundong(List<String> yundong) {
                    this.yundong = yundong;
                }

                public void setZiwaixian(List<String> ziwaixian) {
                    this.ziwaixian = ziwaixian;
                }

                public void setGanmao(List<String> ganmao) {
                    this.ganmao = ganmao;
                }

                public void setXiche(List<String> xiche) {
                    this.xiche = xiche;
                }

                public void setWuran(List<String> wuran) {
                    this.wuran = wuran;
                }

                public void setChuanyi(List<String> chuanyi) {
                    this.chuanyi = chuanyi;
                }

                public List<String> getKongtiao() {
                    return kongtiao;
                }

                public List<String> getYundong() {
                    return yundong;
                }

                public List<String> getZiwaixian() {
                    return ziwaixian;
                }

                public List<String> getGanmao() {
                    return ganmao;
                }

                public List<String> getXiche() {
                    return xiche;
                }

                public List<String> getWuran() {
                    return wuran;
                }

                public List<String> getChuanyi() {
                    return chuanyi;
                }
            }
        }

        public static class Pm25Entity {
            private String key;
            private String show_desc;
            /**
             * curPm : 40
             * pm25 : 17
             * pm10 : 40
             * level : 1
             * quality : 优
             * des : 今天的空气质量令人满意，各类人群可正常活动。
             */

            private Pm25DataEntity pm25;
            private String dateTime;
            private String cityName;

            public void setKey(String key) {
                this.key = key;
            }

            public void setShow_desc(String show_desc) {
                this.show_desc = show_desc;
            }

            public void setPm25(Pm25DataEntity pm25) {
                this.pm25 = pm25;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getKey() {
                return key;
            }

            public String getShow_desc() {
                return show_desc;
            }

            public Pm25DataEntity getPm25() {
                return pm25;
            }

            public String getDateTime() {
                return dateTime;
            }

            public String getCityName() {
                return cityName;
            }

            public static class Pm25DataEntity {
                private String curPm;
                private String pm25;
                private String pm10;
                private String level;
                private String quality;
                private String des;

                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                public String getCurPm() {
                    return curPm;
                }

                public String getPm25() {
                    return pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public String getLevel() {
                    return level;
                }

                public String getQuality() {
                    return quality;
                }

                public String getDes() {
                    return des;
                }
            }
        }

        public static class WeatherEntity {
            private String date;
            private String week;
            private String nongli;
            /**
             * dawn : null
             * day : ["1","多云","20","东风","微风","06:31"]
             * night : ["3","阵雨","14","东南风","微风","19:16"]
             */

            private InfoEntity info;

            public void setDate(String date) {
                this.date = date;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public void setInfo(InfoEntity info) {
                this.info = info;
            }

            public String getDate() {
                return date;
            }

            public String getWeek() {
                return week;
            }

            public String getNongli() {
                return nongli;
            }

            public InfoEntity getInfo() {
                return info;
            }

            public static class InfoEntity {
                private Object dawn;
                private List<String> day;
                private List<String> night;

                public void setDawn(Object dawn) {
                    this.dawn = dawn;
                }

                public void setDay(List<String> day) {
                    this.day = day;
                }

                public void setNight(List<String> night) {
                    this.night = night;
                }

                public Object getDawn() {
                    return dawn;
                }

                public List<String> getDay() {
                    return day;
                }

                public List<String> getNight() {
                    return night;
                }
            }
        }
    }
}
