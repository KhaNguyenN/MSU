clc
clear all
close all 
  

  
path='./standard_test_images/'; % this is your working path
impath=[path,'lena_color_256.tif']; % path of the image
im=imread(impath);
figure,imshow(im); % you could also try image() imagesc() other image display functions 


[r,c,ch]=size(im);
img=zeros(r,c);
img=rgb2gray(im); % change color image to grayscale image 

im_resized=imresize(img,[256,256]);
figure,imshow(im_resized);

for i = 1: 256
    for j = 1: 256
        dist =((i-128)*2+(j-128)*2)*(.5);
        if (dist < 80)
            im_resized(i, j) = 255;
        else
            im_resized(i, j) = 0;
        end
    end
end
image(im_resized);
colormap(gray(256));
axis('image');

%out_impath=[path,'output/','lena_gray_256.tif'];% path of the output im
%imwrite(img,out_impath);
%i=i;