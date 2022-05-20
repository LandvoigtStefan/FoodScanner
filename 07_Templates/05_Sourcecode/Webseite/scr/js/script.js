"use strict";

document.addEventListener("DOMContentLoaded", function (){
    const video  = document.getElementById("video");
    const canvas  =  document.getElementById("canvas");
    const snap =  document.getElementById("btn");
    async function init(){
        try{
            const stream = await navigator.mediaDevices.getUserMedia(constraints);
            handleSucess(stream);
        }
        catch (e){
        }
    }
    const constraints = {
        audio:true,
        video:{
            width:1280, height:720
        }
    };

    init();
    var context = canvas.getContext("2d");
    snap.addEventListener("click", function (){

        context.drawImage(video, 0, 0, 640, 480);

    })
    function handleSucess(stream){
        window.stream = stream;
        video.srcObject = stream;
        video.style.ho
    }
})




