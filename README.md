# Cricket

API: https://cricketdata.org
- register and get api key
- add api key to local.properties with key CRICKET_API_KEY

Dependencies:
1. Accompanist
   - System UI Controller: https://google.github.io/accompanist/systemuicontroller
   - Navigation Animation: https://google.github.io/accompanist/navigation-animation
   - Horizontal Pager: https://google.github.io/accompanist/pager/
2. Dependency Injection: https://developer.android.com/training/dependency-injection/hilt-android
3. HTTP client: https://ktor.io/docs/welcome.html

### Screenshots
- Current match list: uses horizontal scroll pager to navigate between current matches
<p align="center">
<img width="350" src="screenshot/current_matches.png?raw=true">
</p>

- Series list: uses lazy column to load and display series list
![Alt text](screenshot/series_list.png?raw=true)