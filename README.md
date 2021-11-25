#Lab Notepad helps scientists to record their entries and determine the frequency of any word and its similar words.#

__Scope of the solution:__
This software determines the frequency of a word and finds similar words in a notepad entry. The text entered is retained only for the current session. Punctuation marks have not been considered; for example, cats and cat's are considered as the same word.

__Future scope:__
First, I would like to add credential verification so that the user's notepad entries are saved. 
Second, I understand how important punctuation marks are to a scientist, so I would like to incorporate a "search with punctuation" feature in the future.
Third, I would like to introduce a collaboration feature (with authorization/authentication) that would help scientists to share their notepad entries with other scientists (who may not be a user of Lab Notepad but can still give their inputs).

__Development style:__
I used the TDD model to develop the application. First, I started by creating a new Spring Boot application and then created the service class that implements the word frequency count feature and the similar word identification feature, and an additional feature that combines the two previously mentioned features. Then, I created the controller, tested the controller using an API testing tool, and finally created the JSP page that made the corresponding REST calls.

I must confess that I took almost 6 hours to complete the task, primarily because I had to do this by spreading the tasks over many days.
 