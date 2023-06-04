# Cricket

### Overview:

Get api key from following websites to get recent data  

Sr.No.  | Website         | KEY
------------- |-----------------| -------------
1. | https://cricketdata.org | CRICKET_API_KEY 
2.  | https://newsapi.org/  | NEWS_API_KEY    


Dependencies:
1. Accompanist
   - System UI Controller: https://google.github.io/accompanist/systemuicontroller
   - Navigation Animation: https://google.github.io/accompanist/navigation-animation
   - Horizontal Pager: https://google.github.io/accompanist/pager/
2. Dependency Injection: https://developer.android.com/training/dependency-injection/hilt-android
3. HTTP client: https://ktor.io/docs/welcome.html
4. Widgets: https://developer.android.com/jetpack/androidx/releases/glance

### Screenshots
- Current match list: uses horizontal scroll pager to navigate between current matches
- Series list: uses lazy column to load and display series list
- Series info: uses bottom sheet to display series info
- Widget: use androidx glance api to display compose widget
- News Feed: displays news related to cricket
<p align="center">
<img width="300" src="screenshot/current_matches.png?raw=true">
<img width="300" src="screenshot/series_list.png?raw=true">
<img width="300" src="screenshot/series_info_bottom_sheet.png?raw=true">
<img width="300" src="screenshot/current_match_widget.png?raw=true">
<img width="300" src="screenshot/news_feed.png?raw=true">
</p>