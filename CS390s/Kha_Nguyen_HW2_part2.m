clc
clear all
close all 


path='./Image_Folder/'; % this is your working path
impath=[ path,'iris.bmp' ]; % path of the image
im=imread(impath);
figure,imshow(im); % you could also try image() imagesc() other image display functions
title('Original');
im=double(im);
axis image;
axis off;
p=45; %Any number less than this much pixel gets removed

sobelH = [-1 -2 -1
          0  0  0
          1  2  1];
sobelV = [-1 0 1
          -2 0 2
          -1 0 1];
imgSobelH = filter2(sobelH,im,'same');
imgSobelH = bwareaopen(imgSobelH,p); %removing noise

imgSobelV = filter2(sobelV,im,'same');
imgSobelV = bwareaopen(imgSobelV,p); %removing noise

imgSobelFiltered = sqrt((imgSobelH.^2 + imgSobelV.^2)/2);
figure, imshow(imgSobelFiltered);
title('Sobel Filtered');


level = graythresh(imgSobelFiltered); %get the global threshold for the image
irisFiltered = imbinarize(imgSobelFiltered,level); %convert the image into a binary image using the threshold
figure, imshow(irisFiltered);
title('Binary Iris');

%Median filter to remove salt and pepper 
img2=irisFiltered;

medianKernel = [1 1 1
                1 1 1
                1 1 1]/9;
 
for i=2:size(irisFiltered,1)-1
    for j=2:size(irisFiltered,2)-1
tp=irisFiltered(i-1:i+1,j-1:j+1);
img2(i,j)=median(tp(:));
    end
end

img2 = imfilter(irisFiltered,medianKernel,'same');
colormap(gray(256));

iris = bwmorph(img2, 'remove'); %Change and inverse the circle into just the iris
figure, imshow(iris);
title('Iris Circle');

out_impath=[path,'output/','Iris_SobelFiltered.jpg'];% path of the output im
imwrite(imgSobelFiltered,out_impath);
out_impath=[path,'output/','Iris_MedianFiltered.jpg'];% path of the output im
imwrite(img2,out_impath);
out_impath=[path,'output/','Iris.jpg'];% path of the output im
imwrite(iris,out_impath);
