clc
clear all
close all 


path='./Image_Folder/'; % this is your working path
impath=[ path,'RedFlower.jpg' ]; % path of the image
im=imread(impath);
figure,imshow(im); % you could also try image() imagesc() other image display functions 

im_resized=imresize(im,[256,256]); % crop the image to pixel of 256*256

img=rgb2gray(im_resized); % change image to gray scale
out_impath=[path,'output/','Original.jpg'];% path of the output im
imwrite(im,out_impath);
out_impath=[path,'output/','Image_Gray.jpg'];% path of the output im
imwrite(img,out_impath);
figure,imshow(img);

axis image;
axis off;

title('Original Image');

%Averaging Filter
avgR1 = [1 1 1 
         1 1 1
         1 1 1]/9; 
imgFiltered = imfilter(img,avgR1,'same');
figure, imshow(imgFiltered);
title('Average Filtered Image');
out_impath=[path,'output/','Averaging_Filter.jpg'];% path of the output
imwrite(imgFiltered,out_impath);
    
%Sobel Filter
sobelH = [-1 -2 -1
          0  0  0
          1  2  1];
sobelV = [-1 0 1
          -2 0 2
          -1 0 1];
imgSobelH = filter2(sobelH,img,'same');
figure, imshow(imgSobelH);
title('Soble Filtered Horizontal');
imgSobelV = filter2(sobelV,img,'same');
figure, imshow(imgSobelV);
title('Soble Filtered Vertically');
imgSobelFiltered = (imgSobelH + imgSobelV)/2;
figure, imshow(imgSobelFiltered);
title('Sobel Filtered Together');

out_impath=[path,'output/','Sobel_Horizontal.jpg'];% path of the output
imwrite(imgSobelH,out_impath);
out_impath=[path,'output/','Sobel_Vertical.jpg'];% path of the output
imwrite(imgSobelV,out_impath);
out_impath=[path,'output/','Sobel_Filtered.jpg'];% path of the output
imwrite(imgSobelFiltered,out_impath);

%Laplacian Filter
laplacian = [0 1 0
             1 -4 1
             0 1 0];
imgLaplacianFiltered = imfilter(img,laplacian);
figure, imshow(imgLaplacianFiltered);
title('Laplacian Filtered Image');
out_impath=[path,'output/','Laplacian_Filter.jpg'];% path of the output im
imwrite(imgLaplacianFiltered,out_impath);

%Median Filter
img=imnoise(img,'salt & pepper',0.02); %add salt and pepper for median filter
img = double(img);
img2=img;
figure,imagesc(img);
colormap(gray(256));

medianKernel = [1 1 1
                1 1 1
                1 1 1]/9;
 
for i=2:size(img,1)-1
    for j=2:size(img,2)-1
tp=img(i-1:i+1,j-1:j+1);
img2(i,j)=median(tp(:));
    end
end

img2 = imfilter(img,medianKernel,'same');
figure,imagesc(abs(img2));
colormap(gray(256));
title('Median Filtered Image');
out_impath=[path,'output/','Median_Filtered.jpg'];% path of the output im
imwrite(img2,out_impath);

%Robert Filter
img2=rgb2gray(im_resized);
img2=double(img2);
robert1= [-1 0
           0 1];
robert2= [0 -1
          1  0];

im2=imfilter(img2,robert1);
im3=imfilter(img2,robert2);
robertFilter = sqrt((im2.^2+im3.^2)/2);
figure, imagesc(abs(robertFilter));
colormap(gray(256));
title('Robert Filtered Image');
out_impath=[path,'output/','Robert_Filter.jpg'];
imwrite(robertFilter,out_impath);

