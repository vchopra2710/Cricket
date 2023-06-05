# Cricket

### Overview:

Get api key from following websites to get recent data  

Sr.No.  | Website         | Key             | Location         |
------------- |-----------------|-----------------|------------------|
1. | https://cricketdata.org | CRICKET_API_KEY | local.properties |
2. | https://newsapi.org/  | NEWS_API_KEY    | local.properties |
3. | https://console.cloud.google.com/apis/dashboard | google_maps_key | strings.xml      |


Dependencies:
1. Accompanist
   - System UI Controller: https://google.github.io/accompanist/systemuicontroller
   - Navigation Animation: https://google.github.io/accompanist/navigation-animation
   - Horizontal Pager: https://google.github.io/accompanist/pager/
2. Dependency Injection: https://developer.android.com/training/dependency-injection/hilt-android
3. HTTP client: https://ktor.io/docs/welcome.html
4. Widgets: https://developer.android.com/jetpack/androidx/releases/glance
5. Maps: https://medium.com/mobile-development-group/google-maps-android-api-v2-aa62e6fa0fbc

### Screenshots
- Current match list: uses horizontal scroll pager to navigate between current matches
- Series list: uses lazy column to load and display series list
- Series info: uses bottom sheet to display series info
- Widget: use androidx glance api to display compose widget
- Map View: mark cricket playing countries on google map
- News Feed: displays news related to cricket
<p align="center">
<img width="300" src="screenshot/current_matches.png?raw=true">
<img width="300" src="screenshot/series_list.png?raw=true">
<img width="300" src="screenshot/series_info_bottom_sheet.png?raw=true">
<img width="300" src="screenshot/current_match_widget.png?raw=true">
<img width="300" src="screenshot/map_view.png?raw=true">
<img width="300" src="screenshot/news_feed.png?raw=true">
</p>