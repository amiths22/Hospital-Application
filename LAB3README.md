# itmd4515-f22-fp-asatyanarayan1
Amith Satyanarayan Lab 3 README

Below is the screenshot of the form
![image](https://user-images.githubusercontent.com/112361486/191312468-80fec7fc-f288-4ec9-a973-dab59af1e639.png)

The form filled with data
![image](https://user-images.githubusercontent.com/112361486/191312659-06bfaf3b-381f-4abc-b106-31e95205f6e5.png)

Screenshot of form after submission
![image](https://user-images.githubusercontent.com/112361486/191313197-a0bb0359-f452-4d9f-8cb3-bba3d2c46205.png)

Below is the screenshot displaying error message if we submit blank form
![image](https://user-images.githubusercontent.com/112361486/191319427-ad515c2e-37b8-4b15-aa87-48fe7f6bab84.png)

Screenshot of form with bad input
![image](https://user-images.githubusercontent.com/112361486/191319704-9de0530e-59b5-4557-80d2-c1ea940e15ea.png)

Screenshot of form when bad input is submitted
![image](https://user-images.githubusercontent.com/112361486/191319889-db860de2-16c2-48ee-adb3-3996ccb7c549.png)

Screenshot of DB when correct input is given

![image](https://user-images.githubusercontent.com/112361486/191320853-0bcb8ff5-82eb-4d24-868a-4a7957cf91d4.png)

Q&A's

Your understanding of the difference between the forward and redirect operations.
Forward is sending the current request to other methos with all the data. Redirecting will invoke a new request to a different method

How would you be validating user submissions without the Bean Validation API standard?
By checking DB tables and identifying the changes

How do you think this approach would scale to a real application with 100's of entities?
Time to execute will be be increased as number of entities increass

Why didn't we need to include any additional dependencies (i.e. Bean Validation, JDBC) in this project?
We are using servlets and payara server,it has all the bean, hibernate validators by default




