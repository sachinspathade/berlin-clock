Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: All hrs mins secs 1
When the time is 01:01:01
Then the clock should look like
O
OOOO
ROOO
OOOOOOOOOOO
YOOO

Scenario: At the afternoon
When the time is 12:01:01
Then the clock should look like
O
RROO
RROO
OOOOOOOOOOO
YOOO

Scenario: Random time 16:43:08
When the time is 16:43:08
Then the clock should look like
Y
RRRO
ROOO
YYRYYRYYOOO
YYYO



