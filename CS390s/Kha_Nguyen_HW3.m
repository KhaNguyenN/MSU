clc
clear all
close all 


path='./Image_Folder/'; % this is your working path
impath2=[ path,'face_dark.bmp' ]; % path of the image
impath= [path,'face_good.bmp'];
im2=imread(impath2);
im=imread(impath);


figure, imshow(im);

ims1 = (im(:,:,1)>95) & (im(:,:,2)>40) & (im(:,:,3)>20);
ims2 = (im(:,:,1)-im(:,:,2)>15) | (im(:,:,1)-im(:,:,3)>15);
ims3 = (im(:,:,1)-im(:,:,2)>15) & (im(:,:,1)>im(:,:,3));
ims = ims1 & ims2 & ims3;
figure, imshow(ims);

% Mask the image using bsxfun() function
% This functions multiplies the matrices of the im, onto  the logical
% image ims.
 maskedRgbImage = bsxfun(@times, im, cast(ims, 'like', im));
figure, imshow(maskedRgbImage);

out_impath=[path,'output/','Original.jpg'];% path of the output im
imwrite(im,out_impath);
out_impath=[path,'output/','Filtered.jpg'];% path of the output im
imwrite(ims,out_impath);
out_impath=[path,'output/','Final.jpg'];% path of the output im
imwrite(maskedRgbImage,out_impath);
ims1 = (im2(:,:,1)>95) & (im2(:,:,2)>40) & (im2(:,:,3)>20);
ims2 = (im2(:,:,1)-im2(:,:,2)>15) | (im2(:,:,1)-im2(:,:,3)>15);
ims3 = (im2(:,:,1)-im2(:,:,2)>15) & (im2(:,:,1)>im2(:,:,3));
ims4 = ims1 & ims2 & ims3;
figure, imshow(ims4);

figure, imshow(im2);

 imYuv = colorspace('YUV<-RGB',im2);
 Y=imYuv(:,:,1);
 U=imYuv(:,:,2);
 V=imYuv(:,:,3);
 h =imhist(Y);
 
%figure, histogram(Y);
threshold = islocalmin(h,'MinProminence',1);

[k1,k2,k3]=size(imYuv) %Size of the picture
 
 for i=1:k1
    for j=1:k2
        if Y(i,j)>.65
          Y(i,j)=0;
        end      
    end
end
imYuv(:,:,1)=Y;
final = colorspace('RGB<-YUV',imYuv);


figure, imshow(final);

out_impath=[path,'output/','Original2.jpg'];% path of the output im
imwrite(im2,out_impath);
out_impath=[path,'output/','Filtered2.jpg'];% path of the output im
imwrite(ims4,out_impath);
out_impath=[path,'output/','Final2.jpg'];% path of the output im
imwrite(final,out_impath);