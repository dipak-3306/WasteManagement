<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./dist/styles.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
          crossorigin="anonymous">
    <style>
        .login{
            background: url('./dist/images/login-new.jpeg')
        }
    </style>
    <title>Raised CND Request</title>
</head>
<body class="h-screen font-sans login bg-cover">
<div class="container mx-auto h-full flex flex-1 justify-center items-center">
    <div class="w-full max-w-lg">
        <div class="leading-loose">
            <form action ="raisedCnd" method = "post" enctype="multipart/form-data"> 
           
                <p class="text-gray-800 font-medium">Raised CND</p>
                
                <div class="mt-2">
                    <label class="block text-sm text-gray-600" for="address">Address</label>
                    <input class="w-full px-5  py-4 text-gray-700 bg-gray-200 rounded" id="address" name="address" type="text" placeholder="Enter Address Number " aria-label="Address">
                </div>
                
                <div class="">
                    <label class="block text-sm text-gray-00" for="title">Title</label>
                    <input class="w-full px-5 py-1 text-gray-700 bg-gray-200 rounded" id="title" name="title" type="text" placeholder="Enter Title Here" aria-label="Title">
                </div>
                 <div class="">
                    <label class="block text-sm text-gray-00" for="description">Description</label>
                    <input class="w-full px-5 py-1 text-gray-700 bg-gray-200 rounded" id="description" name="description" type="text" placeholder="Enter Description" aria-label="Description">
               <label>Select Image File :</label>
               <input type = "file"  name = "image">
                
               <div class="mt-4">
                    <button class="px-4 py-1 text-white font-light tracking-wider bg-gray-900 rounded" type="submit">Submit</button>
                </div>
                
                  <a href="userdashboard.html" class="hvr-shutter-in-horizontal">go to back</a>
            </form>
        </div>
    </div>
</div>

</body>
</html>