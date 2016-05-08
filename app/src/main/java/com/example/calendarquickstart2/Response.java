package com.example.calendarquickstart2;

import java.util.List;

/**
 * Created by v on 4/27/16.
 */


// when we call the link, aka url api thing, what we are fething from the server.
// here we recive the response.
// with a plugin "GsonFormat" plugin.

// rightclick-> generate-> GsonFormat-> insert the json file from the, that has first been organised in json viewer.
    //-> click format  and ok

public class Response {

    /**
     * bounds : {"northeast":{"lat":55.732629,"lng":12.5923013},"southwest":{"lat":55.66169679999999,"lng":12.5142671}}
     * copyrights : Map data ©2016 Google
     * legs : [{"arrival_time":{"text":"10:10pm","time_zone":"Europe/Copenhagen","value":1462479000},"departure_time":{"text":"9:38pm","time_zone":"Europe/Copenhagen","value":1462477111},"distance":{"text":"14.9 km","value":14854},"duration":{"text":"31 mins","value":1889},"end_address":"2870 Dyssegård, Denmark","end_location":{"lat":55.732629,"lng":12.535743},"start_address":"Valby, København, Denmark","start_location":{"lat":55.66169679999999,"lng":12.5166929},"steps":[{"distance":{"text":"0.4 km","value":365},"duration":{"text":"4 mins","value":269},"end_location":{"lat":55.66399699999999,"lng":12.51445},"html_instructions":"Walk to Valby (Koebenhavn)","polyline":{"points":"slvrIitkkASAG@I@eBh@]F[FsB^c@FFvDDdEY@A?A??AAA?A?CAAACAAAAg@Ak@M"},"start_location":{"lat":55.66169679999999,"lng":12.5166929},"steps":[{"distance":{"text":"79 m","value":79},"duration":{"text":"1 min","value":60},"end_location":{"lat":55.6623962,"lng":12.5164714},"html_instructions":"Head <b>north<\/b> on <b>Toftegårds Pl.<\/b>","polyline":{"points":"slvrIitkkASAG@I@eBh@"},"start_location":{"lat":55.66169679999999,"lng":12.5166929},"travel_mode":"WALKING"},{"distance":{"text":"0.1 km","value":119},"duration":{"text":"2 mins","value":91},"end_location":{"lat":55.66345080000001,"lng":12.5161872},"html_instructions":"Continue onto <b>Toftegårds Allé<\/b>","polyline":{"points":"_qvrI}rkkA]F[FsB^c@F"},"start_location":{"lat":55.6623962,"lng":12.5164714},"travel_mode":"WALKING"},{"distance":{"text":"0.1 km","value":120},"duration":{"text":"1 min","value":83},"end_location":{"lat":55.6633813,"lng":12.5142849},"html_instructions":"Turn <b>left<\/b> onto <b>Lyshøjgårdsvej<\/b>","maneuver":"turn-left","polyline":{"points":"qwvrIeqkkAFvDDdE"},"start_location":{"lat":55.66345080000001,"lng":12.5161872},"travel_mode":"WALKING"},{"distance":{"text":"47 m","value":47},"duration":{"text":"1 min","value":35},"end_location":{"lat":55.66399699999999,"lng":12.51445},"html_instructions":"Turn <b>right<\/b> at <b>Overskousvej<\/b>","maneuver":"turn-right","polyline":{"points":"cwvrIgekkAY@A?A??AAA?A?CAAACAAAAg@Ak@M"},"start_location":{"lat":55.6633813,"lng":12.5142849},"travel_mode":"WALKING"}],"travel_mode":"WALKING"},{"distance":{"text":"14.5 km","value":14489},"duration":{"text":"27 mins","value":1620},"end_location":{"lat":55.732629,"lng":12.535743},"html_instructions":"Commuter train towards Farum St.","polyline":{"points":"_{vrIifkkAZ@@eABcF?yB?Y@kB?mBBwE@eA@qB?c@@cD@sB@sBB}GDqI@qBDqJBcE@aD@wCBsCH}IHaJDcDHwID_BDgBHaDB}@Bu@Bi@ZF@GFiAJyAHeAD_@NeCR_DHuBBoB@iBCgBGeBGcAK_BOwAOwAQyAQyAOsAQ_BO}AKuAI_AIwAK_BEcAGyAG_BOyDIwBGkBKsBGcBG_AGqAIyAIkBK}AKoAIs@K_AMu@SkAESI]U}@I]Mc@Um@Ws@a@aAg@gAUc@a@_A]u@]w@]aAa@iAc@oAc@mAa@iASm@Yo@c@{@a@s@QWMQ?AKIIKMMQUOMGGMKKIAAQOKIMMQMAAOOSQSQUOSKSMe@OQEICYI]ISCA?AAWGWGWEUC]CU?UBKBYDOFWJWJYNUNOJOJ}DhEw@~@g@qB_BdB]`@yA`Bc@h@SNQPiAlAcA~@y@f@o@RC??|@a@@[AWAWCUEQCSE[K[KYMKGOGOIKEo@e@g@e@II_@a@[a@Ya@]k@Ue@Oc@EOCMEOCOGQOu@Qm@Mi@YcAQe@Uc@W_@c@k@kCkDiA_BeA{AoAaBoBmCgBmCu@eAo@gAQ][i@y@_BsBqDyBoDsBmDmB}CaBsCcAiBeAyB{@gBi@eAk@kAYm@]s@a@aA[q@M]GKM[KWIQM[[y@[{@CKM]I]mA}CGIIOIQGOQa@Wq@Oa@EGO_@M_@Qa@KUGOQa@Ue@Yk@Wg@Yk@We@Yk@}AwCqAiCyBeEGKQ_@w@}AaAiBgAuBU_@mBeDe@s@wBmC_@_@_Aw@KEYQGE]Qe@Q]K_@Ke@Ie@CGC[AY?K?Y@Y@YB]Dg@Fe@Fi@Fa@D[BWBoALsAHe@BoAJuAJkAHcAHuAHoAJsAHm@FaAFYBe@D_@B_@BG@}@Di@F_AJ[D]Hy@Rq@TOFDh@WFg@Ng@Li@No@P_@Jc@N]LC?c@PE?e@Re@Nm@Tg@Pg@PEBe@Pg@Pa@NC@_@NC@c@Ne@Tg@V[Pa@Va@Z]V]Xa@Z[Xc@b@i@h@e@h@g@j@u@~@wAjBeAfBgAbC]x@mAnDY~@ENOj@[hAOf@I\\Ql@Mh@Of@St@Kb@Ol@[dAQp@U|@WbAW~@a@xAq@jCM^Op@Qn@Of@i@tBs@lCK^Kd@e@vBKp@OdASdBEl@Ex@GlACn@C~BEtDCtDE~DA`CAx@?lAAx@?NAvA?JCpCA\\AhBAzC@bA@`@@v@FjADj@HlAFd@NlAJx@Pv@Nv@Rx@Z`A\\bAZt@d@~@^n@j@x@p@|@HJDHNPf@n@\\h@b@p@d@t@d@z@BFb@x@\\p@^t@`@v@d@bARf@Vn@h@vABFh@fB\\nA^vA^~AFTJb@Lp@Lt@Hn@Fj@BLNrAHr@H~@HnADpA@jA?|@Ct@?FCp@?DG~@KbAIr@G^G\\ETETQr@Uz@[z@]v@a@v@[f@WZc@d@u@j@o@\\u@Xg@Nk@Nw@TWHm@Tk@Xi@ZkAv@eAr@mAz@m@`@wAbAk@`@sA~@}B|A}AdAmAz@w@h@YRYTUNqCfB[Re@Xi@\\gAn@c@Pm@V_@LoCz@yEpAmBj@mD`AqCv@aAXMBMDaBb@cG~AuEpAcCr@wCv@oA`@s@\\y@d@a@T_@VkAt@e@V"},"start_location":{"lat":55.66399699999999,"lng":12.51445},"transit_details":{"arrival_stop":{"location":{"lat":55.732629,"lng":12.535743},"name":"Dyssegård St."},"arrival_time":{"text":"10:10pm","time_zone":"Europe/Copenhagen","value":1462479000},"departure_stop":{"location":{"lat":55.66399699999999,"lng":12.51445},"name":"Valby (Koebenhavn)"},"departure_time":{"text":"9:43pm","time_zone":"Europe/Copenhagen","value":1462477380},"headsign":"Farum St.","line":{"agencies":[{"name":"DSB S-tog","phone":"011 45 70 13 14 15","url":"http://www.dsb.dk/"}],"short_name":"B","vehicle":{"icon":"//maps.gstatic.com/mapfiles/transit/iw2/6/rail.png","name":"Commuter train","type":"COMMUTER_TRAIN"}},"num_stops":11},"travel_mode":"TRANSIT"}],"via_waypoint":[]}]
     * overview_polyline : {"points":"slvrIitkkA[?oBj@qEv@L|J[@CCCKCCg@Ak@MZ@@eAB}IDkMRwe@LiYXk^N{NJgEL_FF_BZF@GRcDr@kKLeFAqEOiD[wDcA_Ja@}DUuCc@uIi@}Nc@iJSeEWmDUsBa@aCo@mCc@qAy@uB}BaFaCsGeAwCm@}AeAoB_@i@c@e@cB}Aq@m@g@c@i@[y@][ImAWiAWUCs@Ca@Fi@Lo@Vo@^_@VuFhGg@qB_BdBwBbCsCxCcA~@y@f@o@RC??|@a@@s@Cm@Ie@Iw@WeAg@{@k@q@o@{@cAw@mAe@iAI]a@gB_@wAk@iBm@cAoDwEoIkL}CsEaAeBuAiCmFaJaFkIeD}FwEsJuBuEo@}AoAcDQi@wA{Dc@{@{BuFiAcCcBeDeOqYcCeE}CaE_BwAe@We@WcA]eAUm@G{A?s@DeALmCXaF^}QrAqHh@{APwA\\aA\\Dh@WFoA\\yA`@eBh@yFrBsBt@mBv@cAh@cAr@yBfBmAlAmAtAmCjDeAfBgAbCkBhF_@nAeAzDmC~JiEhPyBjIq@|C[vBYrCMfCGnDIjJIhMClDItLBdBHbCNxBVrB\\pBb@pBx@dC`AtBjAhBz@hAzAtBhAfBh@bAbCxEx@jB`AfCjBvG`AjEb@~CXfCRnCF|CCrBK~BUvBO|@Kj@g@nBy@rB}@~A{@`Au@j@o@\\}Ah@cBd@eA^uAt@mGhEuIbG}F~D}E`DoAv@kB`AmAd@iJlCoN~DaKlCyIdCgFxAmBbAaAl@qBlA"}
     * summary :
     * warnings : ["Walking directions are in beta.    Use caution \u2013 This route may be missing sidewalks or pedestrian paths."]
     * waypoint_order : []
     */

    private List<RoutesBean> routes;

    public List<RoutesBean> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutesBean> routes) {
        this.routes = routes;
    }

    public static class RoutesBean {
        /**
         * points : slvrIitkkA[?oBj@qEv@L|J[@CCCKCCg@Ak@MZ@@eAB}IDkMRwe@LiYXk^N{NJgEL_FF_BZF@GRcDr@kKLeFAqEOiD[wDcA_Ja@}DUuCc@uIi@}Nc@iJSeEWmDUsBa@aCo@mCc@qAy@uB}BaFaCsGeAwCm@}AeAoB_@i@c@e@cB}Aq@m@g@c@i@[y@][ImAWiAWUCs@Ca@Fi@Lo@Vo@^_@VuFhGg@qB_BdBwBbCsCxCcA~@y@f@o@RC??|@a@@s@Cm@Ie@Iw@WeAg@{@k@q@o@{@cAw@mAe@iAI]a@gB_@wAk@iBm@cAoDwEoIkL}CsEaAeBuAiCmFaJaFkIeD}FwEsJuBuEo@}AoAcDQi@wA{Dc@{@{BuFiAcCcBeDeOqYcCeE}CaE_BwAe@We@WcA]eAUm@G{A?s@DeALmCXaF^}QrAqHh@{APwA\aA\Dh@WFoA\yA`@eBh@yFrBsBt@mBv@cAh@cAr@yBfBmAlAmAtAmCjDeAfBgAbCkBhF_@nAeAzDmC~JiEhPyBjIq@|C[vBYrCMfCGnDIjJIhMClDItLBdBHbCNxBVrB\pBb@pBx@dC`AtBjAhBz@hAzAtBhAfBh@bAbCxEx@jB`AfCjBvG`AjEb@~CXfCRnCF|CCrBK~BUvBO|@Kj@g@nBy@rB}@~A{@`Au@j@o@\}Ah@cBd@eA^uAt@mGhEuIbG}F~D}E`DoAv@kB`AmAd@iJlCoN~DaKlCyIdCgFxAmBbAaAl@qBlA
         */

        private OverviewPolylineBean overview_polyline;
        private String summary;
        /**
         * arrival_time : {"text":"10:10pm","time_zone":"Europe/Copenhagen","value":1462479000}
         * departure_time : {"text":"9:38pm","time_zone":"Europe/Copenhagen","value":1462477111}
         * distance : {"text":"14.9 km","value":14854}
         * duration : {"text":"31 mins","value":1889}
         * end_address : 2870 Dyssegård, Denmark
         * end_location : {"lat":55.732629,"lng":12.535743}
         * start_address : Valby, København, Denmark
         * start_location : {"lat":55.66169679999999,"lng":12.5166929}
         * steps : [{"distance":{"text":"0.4 km","value":365},"duration":{"text":"4 mins","value":269},"end_location":{"lat":55.66399699999999,"lng":12.51445},"html_instructions":"Walk to Valby (Koebenhavn)","polyline":{"points":"slvrIitkkASAG@I@eBh@]F[FsB^c@FFvDDdEY@A?A??AAA?A?CAAACAAAAg@Ak@M"},"start_location":{"lat":55.66169679999999,"lng":12.5166929},"steps":[{"distance":{"text":"79 m","value":79},"duration":{"text":"1 min","value":60},"end_location":{"lat":55.6623962,"lng":12.5164714},"html_instructions":"Head <b>north<\/b> on <b>Toftegårds Pl.<\/b>","polyline":{"points":"slvrIitkkASAG@I@eBh@"},"start_location":{"lat":55.66169679999999,"lng":12.5166929},"travel_mode":"WALKING"},{"distance":{"text":"0.1 km","value":119},"duration":{"text":"2 mins","value":91},"end_location":{"lat":55.66345080000001,"lng":12.5161872},"html_instructions":"Continue onto <b>Toftegårds Allé<\/b>","polyline":{"points":"_qvrI}rkkA]F[FsB^c@F"},"start_location":{"lat":55.6623962,"lng":12.5164714},"travel_mode":"WALKING"},{"distance":{"text":"0.1 km","value":120},"duration":{"text":"1 min","value":83},"end_location":{"lat":55.6633813,"lng":12.5142849},"html_instructions":"Turn <b>left<\/b> onto <b>Lyshøjgårdsvej<\/b>","maneuver":"turn-left","polyline":{"points":"qwvrIeqkkAFvDDdE"},"start_location":{"lat":55.66345080000001,"lng":12.5161872},"travel_mode":"WALKING"},{"distance":{"text":"47 m","value":47},"duration":{"text":"1 min","value":35},"end_location":{"lat":55.66399699999999,"lng":12.51445},"html_instructions":"Turn <b>right<\/b> at <b>Overskousvej<\/b>","maneuver":"turn-right","polyline":{"points":"cwvrIgekkAY@A?A??AAA?A?CAAACAAAAg@Ak@M"},"start_location":{"lat":55.6633813,"lng":12.5142849},"travel_mode":"WALKING"}],"travel_mode":"WALKING"},{"distance":{"text":"14.5 km","value":14489},"duration":{"text":"27 mins","value":1620},"end_location":{"lat":55.732629,"lng":12.535743},"html_instructions":"Commuter train towards Farum St.","polyline":{"points":"_{vrIifkkAZ@@eABcF?yB?Y@kB?mBBwE@eA@qB?c@@cD@sB@sBB}GDqI@qBDqJBcE@aD@wCBsCH}IHaJDcDHwID_BDgBHaDB}@Bu@Bi@ZF@GFiAJyAHeAD_@NeCR_DHuBBoB@iBCgBGeBGcAK_BOwAOwAQyAQyAOsAQ_BO}AKuAI_AIwAK_BEcAGyAG_BOyDIwBGkBKsBGcBG_AGqAIyAIkBK}AKoAIs@K_AMu@SkAESI]U}@I]Mc@Um@Ws@a@aAg@gAUc@a@_A]u@]w@]aAa@iAc@oAc@mAa@iASm@Yo@c@{@a@s@QWMQ?AKIIKMMQUOMGGMKKIAAQOKIMMQMAAOOSQSQUOSKSMe@OQEICYI]ISCA?AAWGWGWEUC]CU?UBKBYDOFWJWJYNUNOJOJ}DhEw@~@g@qB_BdB]`@yA`Bc@h@SNQPiAlAcA~@y@f@o@RC??|@a@@[AWAWCUEQCSE[K[KYMKGOGOIKEo@e@g@e@II_@a@[a@Ya@]k@Ue@Oc@EOCMEOCOGQOu@Qm@Mi@YcAQe@Uc@W_@c@k@kCkDiA_BeA{AoAaBoBmCgBmCu@eAo@gAQ][i@y@_BsBqDyBoDsBmDmB}CaBsCcAiBeAyB{@gBi@eAk@kAYm@]s@a@aA[q@M]GKM[KWIQM[[y@[{@CKM]I]mA}CGIIOIQGOQa@Wq@Oa@EGO_@M_@Qa@KUGOQa@Ue@Yk@Wg@Yk@We@Yk@}AwCqAiCyBeEGKQ_@w@}AaAiBgAuBU_@mBeDe@s@wBmC_@_@_Aw@KEYQGE]Qe@Q]K_@Ke@Ie@CGC[AY?K?Y@Y@YB]Dg@Fe@Fi@Fa@D[BWBoALsAHe@BoAJuAJkAHcAHuAHoAJsAHm@FaAFYBe@D_@B_@BG@}@Di@F_AJ[D]Hy@Rq@TOFDh@WFg@Ng@Li@No@P_@Jc@N]LC?c@PE?e@Re@Nm@Tg@Pg@PEBe@Pg@Pa@NC@_@NC@c@Ne@Tg@V[Pa@Va@Z]V]Xa@Z[Xc@b@i@h@e@h@g@j@u@~@wAjBeAfBgAbC]x@mAnDY~@ENOj@[hAOf@I\\Ql@Mh@Of@St@Kb@Ol@[dAQp@U|@WbAW~@a@xAq@jCM^Op@Qn@Of@i@tBs@lCK^Kd@e@vBKp@OdASdBEl@Ex@GlACn@C~BEtDCtDE~DA`CAx@?lAAx@?NAvA?JCpCA\\AhBAzC@bA@`@@v@FjADj@HlAFd@NlAJx@Pv@Nv@Rx@Z`A\\bAZt@d@~@^n@j@x@p@|@HJDHNPf@n@\\h@b@p@d@t@d@z@BFb@x@\\p@^t@`@v@d@bARf@Vn@h@vABFh@fB\\nA^vA^~AFTJb@Lp@Lt@Hn@Fj@BLNrAHr@H~@HnADpA@jA?|@Ct@?FCp@?DG~@KbAIr@G^G\\ETETQr@Uz@[z@]v@a@v@[f@WZc@d@u@j@o@\\u@Xg@Nk@Nw@TWHm@Tk@Xi@ZkAv@eAr@mAz@m@`@wAbAk@`@sA~@}B|A}AdAmAz@w@h@YRYTUNqCfB[Re@Xi@\\gAn@c@Pm@V_@LoCz@yEpAmBj@mD`AqCv@aAXMBMDaBb@cG~AuEpAcCr@wCv@oA`@s@\\y@d@a@T_@VkAt@e@V"},"start_location":{"lat":55.66399699999999,"lng":12.51445},"transit_details":{"arrival_stop":{"location":{"lat":55.732629,"lng":12.535743},"name":"Dyssegård St."},"arrival_time":{"text":"10:10pm","time_zone":"Europe/Copenhagen","value":1462479000},"departure_stop":{"location":{"lat":55.66399699999999,"lng":12.51445},"name":"Valby (Koebenhavn)"},"departure_time":{"text":"9:43pm","time_zone":"Europe/Copenhagen","value":1462477380},"headsign":"Farum St.","line":{"agencies":[{"name":"DSB S-tog","phone":"011 45 70 13 14 15","url":"http://www.dsb.dk/"}],"short_name":"B","vehicle":{"icon":"//maps.gstatic.com/mapfiles/transit/iw2/6/rail.png","name":"Commuter train","type":"COMMUTER_TRAIN"}},"num_stops":11},"travel_mode":"TRANSIT"}]
         * via_waypoint : []
         */

        private List<LegsBean> legs;

        public OverviewPolylineBean getOverview_polyline() {
            return overview_polyline;
        }

        public void setOverview_polyline(OverviewPolylineBean overview_polyline) {
            this.overview_polyline = overview_polyline;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<LegsBean> getLegs() {
            return legs;
        }

        public void setLegs(List<LegsBean> legs) {
            this.legs = legs;
        }

        public static class OverviewPolylineBean {
            private String points;

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }
        }

        public static class LegsBean {
            /**
             * text : 10:10pm
             * time_zone : Europe/Copenhagen
             * value : 1462479000
             */

            private ArrivalTimeBean arrival_time;
            /**
             * text : 9:38pm
             * time_zone : Europe/Copenhagen
             * value : 1462477111
             */

            private DepartureTimeBean departure_time;
            /**
             * text : 14.9 km
             * value : 14854
             */

            private DistanceBean distance;
            /**
             * text : 31 mins
             * value : 1889
             */

            private DurationBean duration;
            private String end_address;
            /**
             * lat : 55.732629
             * lng : 12.535743
             */

            private EndLocationBean end_location;
            private String start_address;
            /**
             * lat : 55.66169679999999
             * lng : 12.5166929
             */

            private StartLocationBean start_location;
            /**
             * distance : {"text":"0.4 km","value":365}
             * duration : {"text":"4 mins","value":269}
             * end_location : {"lat":55.66399699999999,"lng":12.51445}
             * html_instructions : Walk to Valby (Koebenhavn)
             * polyline : {"points":"slvrIitkkASAG@I@eBh@]F[FsB^c@FFvDDdEY@A?A??AAA?A?CAAACAAAAg@Ak@M"}
             * start_location : {"lat":55.66169679999999,"lng":12.5166929}
             * steps : [{"distance":{"text":"79 m","value":79},"duration":{"text":"1 min","value":60},"end_location":{"lat":55.6623962,"lng":12.5164714},"html_instructions":"Head <b>north<\/b> on <b>Toftegårds Pl.<\/b>","polyline":{"points":"slvrIitkkASAG@I@eBh@"},"start_location":{"lat":55.66169679999999,"lng":12.5166929},"travel_mode":"WALKING"},{"distance":{"text":"0.1 km","value":119},"duration":{"text":"2 mins","value":91},"end_location":{"lat":55.66345080000001,"lng":12.5161872},"html_instructions":"Continue onto <b>Toftegårds Allé<\/b>","polyline":{"points":"_qvrI}rkkA]F[FsB^c@F"},"start_location":{"lat":55.6623962,"lng":12.5164714},"travel_mode":"WALKING"},{"distance":{"text":"0.1 km","value":120},"duration":{"text":"1 min","value":83},"end_location":{"lat":55.6633813,"lng":12.5142849},"html_instructions":"Turn <b>left<\/b> onto <b>Lyshøjgårdsvej<\/b>","maneuver":"turn-left","polyline":{"points":"qwvrIeqkkAFvDDdE"},"start_location":{"lat":55.66345080000001,"lng":12.5161872},"travel_mode":"WALKING"},{"distance":{"text":"47 m","value":47},"duration":{"text":"1 min","value":35},"end_location":{"lat":55.66399699999999,"lng":12.51445},"html_instructions":"Turn <b>right<\/b> at <b>Overskousvej<\/b>","maneuver":"turn-right","polyline":{"points":"cwvrIgekkAY@A?A??AAA?A?CAAACAAAAg@Ak@M"},"start_location":{"lat":55.6633813,"lng":12.5142849},"travel_mode":"WALKING"}]
             * travel_mode : WALKING
             */

            private List<StepsBean> steps;

            public ArrivalTimeBean getArrival_time() {
                return arrival_time;
            }

            public void setArrival_time(ArrivalTimeBean arrival_time) {
                this.arrival_time = arrival_time;
            }

            public DepartureTimeBean getDeparture_time() {
                return departure_time;
            }

            public void setDeparture_time(DepartureTimeBean departure_time) {
                this.departure_time = departure_time;
            }

            public DistanceBean getDistance() {
                return distance;
            }

            public void setDistance(DistanceBean distance) {
                this.distance = distance;
            }

            public DurationBean getDuration() {
                return duration;
            }

            public void setDuration(DurationBean duration) {
                this.duration = duration;
            }

            public String getEnd_address() {
                return end_address;
            }

            public void setEnd_address(String end_address) {
                this.end_address = end_address;
            }

            public EndLocationBean getEnd_location() {
                return end_location;
            }

            public void setEnd_location(EndLocationBean end_location) {
                this.end_location = end_location;
            }

            public String getStart_address() {
                return start_address;
            }

            public void setStart_address(String start_address) {
                this.start_address = start_address;
            }

            public StartLocationBean getStart_location() {
                return start_location;
            }

            public void setStart_location(StartLocationBean start_location) {
                this.start_location = start_location;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public void setSteps(List<StepsBean> steps) {
                this.steps = steps;
            }

            public static class ArrivalTimeBean {
                private String text;
                private String time_zone;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getTime_zone() {
                    return time_zone;
                }

                public void setTime_zone(String time_zone) {
                    this.time_zone = time_zone;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class DepartureTimeBean {
                private String text;
                private String time_zone;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getTime_zone() {
                    return time_zone;
                }

                public void setTime_zone(String time_zone) {
                    this.time_zone = time_zone;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class DistanceBean {
                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class DurationBean {
                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class EndLocationBean {
                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class StartLocationBean {
                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class StepsBean {
                /**
                 * text : 0.4 km
                 * value : 365
                 */

                private DistanceBean distance;
                /**
                 * text : 4 mins
                 * value : 269
                 */

                private DurationBean duration;
                /**
                 * lat : 55.66399699999999
                 * lng : 12.51445
                 */

                private EndLocationBean end_location;
                private String html_instructions;
                /**
                 * points : slvrIitkkASAG@I@eBh@]F[FsB^c@FFvDDdEY@A?A??AAA?A?CAAACAAAAg@Ak@M
                 */

                private PolylineBean polyline;
                /**
                 * lat : 55.66169679999999
                 * lng : 12.5166929
                 */

                private StartLocationBean start_location;
                private String travel_mode;

                public DistanceBean getDistance() {
                    return distance;
                }

                public void setDistance(DistanceBean distance) {
                    this.distance = distance;
                }

                public DurationBean getDuration() {
                    return duration;
                }

                public void setDuration(DurationBean duration) {
                    this.duration = duration;
                }

                public EndLocationBean getEnd_location() {
                    return end_location;
                }

                public void setEnd_location(EndLocationBean end_location) {
                    this.end_location = end_location;
                }

                public String getHtml_instructions() {
                    return html_instructions;
                }

                public void setHtml_instructions(String html_instructions) {
                    this.html_instructions = html_instructions;
                }

                public PolylineBean getPolyline() {
                    return polyline;
                }

                public void setPolyline(PolylineBean polyline) {
                    this.polyline = polyline;
                }

                public StartLocationBean getStart_location() {
                    return start_location;
                }

                public void setStart_location(StartLocationBean start_location) {
                    this.start_location = start_location;
                }

                public String getTravel_mode() {
                    return travel_mode;
                }

                public void setTravel_mode(String travel_mode) {
                    this.travel_mode = travel_mode;
                }

                public static class DistanceBean {
                    private String text;
                    private int value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                public static class DurationBean {
                    private String text;
                    private int value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                public static class EndLocationBean {
                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class PolylineBean {
                    private String points;

                    public String getPoints() {
                        return points;
                    }

                    public void setPoints(String points) {
                        this.points = points;
                    }
                }

                public static class StartLocationBean {
                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }
    }
}