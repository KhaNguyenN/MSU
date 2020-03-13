clc
clear all
close all 


path='./Kha_Nguyen_HW5/'; % this is your working path
impath= [path,'Flower2.jpg'];
im=imread(impath);

im_Original=imresize(im,[256,256]); % crop the image to pixel of 256*256

out_impath=[path,'Flower_Sized.jpg'];% path of the output im
imwrite(im_Original,out_impath);
imS = im_Original;
imD = im_Original;

figure, imshow(im_Original);
load('Flower.mat');
figure, imshow(salMap.data);

im_Original = rgb2gray(im_Original);
%SSIM required
K = [0.01 0.03];
window = fspecial('gaussian', 11, 1.5);
L = 255;
%For Saliency, cropped by hand
imSaliency = im_Original;
imSaliency(86:162, 72:151, :)=0;
imS(86:162, 72:151, :)=0;

%For Distorted, cropped by hand
imDistorted = im_Original;
imDistorted(182:256, 180:256, :)=0;
imD(182:256, 180:256, :)=0;

%To show where the image is cropped
figure, imshow(imS);
figure, imshow(imD);

%If the image is the same then the value is infinite, higher the better
PSNR_1=psnr(im_Original,imSaliency);  
PSNR_2=psnr(im_Original,imDistorted);

%If the image is the same then the value is 1, closer to one the better
SSIM_1=ssim(im_Original,imSaliency,K,window,L)
SSIM_2=ssim(im_Original,imDistorted,K,window,L)

%If the image has a smaller value the better, perfect would be a zero 0
%Using built in function for this value
MSE_1=immse(im_Original, imSaliency);
MSE_2=immse(im_Original, imDistorted);





