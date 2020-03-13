clc
clear all
close all 


path='./Image_Folder/'; % this is your working path
impath=[ path,'face_good.bmp' ]; % path of the image
im=imread(impath);
figure,imshow(im); % you could also try image() imagesc() other image display functions 

im_resized=imresize(im,[512,512]); % crop the image to pixel of 512x512

img=rgb2gray(im_resized); % change image to gray scale

for i=1:512
    for j=1:512
        if round(sqrt((i-256)^2+(j-256)^2))< 160 %crop the circle
        img;
        else
            img(i,j) = 0;
        end      
    end
end
figure,imshow(img) %show the finished cropped image
out_impath=[path,'output/','Frost.tif'];% path of the output im
imwrite(img,out_impath);
  