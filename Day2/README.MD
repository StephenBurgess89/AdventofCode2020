<html>
<body>
<main>
  <div>
    <h1>My Output:<br></h1>
    <p><strong>Valid passwords (One): 638</strong></p>
    <p><strong><br>Valid passwords (Two): 699</strong></p>
  </div>
  
  <h1>My Code:<br></h1>
  <h2>Answer One:</h2>
  
  ```java
  public static int answerOne(String[] passwords) {
      int count = 0;
      for(String s : passwords) {

        String[] data = s.split(":");

        String key = data[0];
        String password = data[1].trim();
        
        data = key.split(" ");
        int lower = getLower(data[0]);
        int upper = getUpper(data[0]);

        String letter = data[1];

        String[] letters = password.split("");
        int matches = 0;
        for(String l : letters) {
          if(l.equals(letter)){
            matches++;
          }
        }
        if(matches <= upper && matches >= lower){
          count++;
        }
      }
      return count;
  }
  ```
  <h2>Answer Two:</h2>
  
  ```java
  public static int answerTwo(String[] passwords) {
      int count = 0;
      for(String s : passwords) {

        String[] data = s.split(":");

        String key = data[0];
        String password = data[1].trim();
        
        data = key.split(" ");
        int lower = getLower(data[0]);
        int upper = getUpper(data[0]);

        String letter = data[1];

        String[] letters = password.split("");
        if( letters[lower-1].equals(letter) ^ letters[upper-1].equals(letter)){
          count ++;
        }      
      }
      return count;
  }
  ```
  <article class="day-desc"><h2>--- Day 2: Password Philosophy ---</h2><p>Your flight departs in a few days from the coastal airport; the easiest way down to the coast from here is via <a href="https://en.wikipedia.org/wiki/Toboggan" target="_blank">toboggan</a>.</p>
<p>The shopkeeper at the North Pole Toboggan Rental Shop is having a bad day. "Something's wrong with our computers; we can't log in!" You ask if you can take a look.</p>
<p>Their password database seems to be a little corrupted: some of the passwords wouldn't have been allowed by the <span title="To ensure your safety, your password must be the following string...">Official Toboggan Corporate Policy</span> that was in effect when they were chosen.</p>
<p>To try to debug the problem, they have created a list (your puzzle input) of <em>passwords</em> (according to the corrupted database) and <em>the corporate policy when that password was set</em>.</p>
<p>For example, suppose you have the following list:</p>
<pre><code>1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
</code></pre>
<p>Each line gives the password policy and then the password. The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid. For example, <code>1-3 a</code> means that the password must contain <code>a</code> at least <code>1</code> time and at most <code>3</code> times.</p>
<p>In the above example, <code><em>2</em></code> passwords are valid. The middle password, <code>cdefg</code>, is not; it contains no instances of <code>b</code>, but needs at least <code>1</code>. The first and third passwords are valid: they contain one <code>a</code> or nine <code>c</code>, both within the limits of their respective policies.</p>
<p><em>How many passwords are valid</em> according to their policies?</p>
</article>
  
 </main>
 </body>
 </html>
