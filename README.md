SendSMS
=======

PhoneGap SMS Plugin
This Plugin will allow you to send SMS 

Platforms
========
Android

Usage 
========
adding plugin to your project just call


cordova plugin add http://www.github.com/aijazalikhokhar/SendSMS

phonegap local plugin add http://www.github.com/aijazalikhokhar/SendSMS

In your javascript Device Ready method call

window.SMS.send(phoneNumber,Message,onSucess,onError);

Example
========
var number = '1234567';
var message = 'Hello World';
function onSuccess(msg){
  console.log('Message Sent'+msg);
}
function onError(err){
  console.log('Error '+err);
}
$(document).ready(function(){
  window.SMS.send(number,message,onSuccess,onError);
});

