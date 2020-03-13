clc
clear all
close all
%%%%%%%%%%%%%%%% enhancement %%%%%%%%%%%%%%%%%%%%%%
% im_pro =imread('./FaceRecognition/images_4persons/testing/person01_01d.png');
im_pro =imread('./FaceRecognition/Dataset/testing/ID01_010.bmp');
im_en=histeq(im_pro);
%%%%%%%%%%%%%%%%%%%%% TRAINING %%%%%%%%%%%%%%%%%%%%
imlist=dir('./FaceRecognition/Dataset/enrolling/*.bmp');
im =imread(['./FaceRecognition/Dataset/enrolling/',imlist(1).name]);
[r,c]=size(im);
num_im=length(imlist);
num_p=num_im/5; %Change for the number for the number of people
x=zeros(r*c,num_p);
im_vector=zeros(r*c,num_im);
Mec=zeros(r*c,1);
index=zeros;index2=zeros; 
match=zeros(1,10);match2=zeros(1,10);
cmc=zeros(1,10);
cmc2=zeros(1,10);
%%%%%% convert all images to vector %%%%%%%%%%%%%%%%%%%%%%%
for i=1:num_im
im =imread(['./FaceRecognition/Dataset/enrolling/',imlist(i).name]);
im_vector(:,i)=reshape(im',r*c,1);
end

%%%%%%%%%%%%%% to get xi and Me%%%%%%%%%%%%%%%%
j=1;
for i=1:2:(num_im-1) %Change for the number of people
x(:,j)=(im_vector(:,i)+im_vector(:,i+1))./5;%Change for the number of people 
Mec(:,1)=Mec(:,1)+im_vector(:,i)+im_vector(:,i+1);
j=j+1;
end
Me=Mec(:,1)./num_im;

%%%%%%%%%%%%%% to get big A %%%%%%%%%%%%%%%%%%%%
for i=1:num_p
a(:,i)=x(:,i)-Me;
end

%%%%%%%%%%%%%% to get eig of A'*A (P2) %%%%%%%%%
ata = a'*a;  
[V D] = eig(ata);
p2 = [];
for i = 1 : size(V,2) 
    if( D(i,i)>1 )
        p2 = [p2 V(:,i)];
    end
end
%%%weight of the training data projected into eigen space%%%%%
wta=p2'*ata; % A*P2= P;  P'*A =Wt_A
plot(wta(:,1));title('Weights representing Faces of Person1');
figure,plot(wta(:,2));title('Weights representing Faces of Person2');
figure,plot(wta(:,3));title('Weights representing Faces of Person3');
figure,plot(wta(:,4));title('Weights representing Faces of Person4');
figure,plot(wta(:,5));title('Weights representing Faces of Person5');

%%%%%%%%%%%%%% to get the Eigenfaces %%%%%%%%%%%%
ef =a*p2;  %here is the P you need to use in matching 
[rr,cc]=size(ef);

for i=1:cc
eigim_t=ef(:,i);
eigface(:,:,i)=reshape(eigim_t,r,c);
figure,imagesc(eigface(:,:,i)');
axis image;axis off; colormap(gray(256));
title('Eigen Face Image','fontsize',10);
end

%%%%%%%%%%%%%%%%%%%%%%%  TESTING  %%%%%%%%%%%%%%%%%%%%%%%%
imlist2=dir('./testing/*.bmp');
num_imt=length(imlist2);
imt_vector=zeros(r*c,num_imt);

%%%%%% convert all test images to vector %%%%%%
for i=1:num_imt
im =imread(['./testing/',imlist2(i).name]);
imt_vector(:,i)=reshape(im',r*c,1);
%%%%% get B=y-me %%%%%%%
b(:,i)=imt_vector(:,i)-Me;  %% bi=imt_vector(i)-Me;
wtb=ef'*b(:,i);  %%wtb=P'*bi;
for ii=1:num_p   %% weight compare wtb and wta(i)
 eud(ii)=sqrt(sum((wtb-wta(:,ii)).^2));
end
[cdata index(i)]=min(eud);  %% find minimum  eud's index

%%%%%%%%%%%%%%%%%%%%%%%  RESULT  %%%%%%%%%%%%%%%%%%%%%%%%
%%% right result by observation is 1 1 2 3 4 %%%%%
rresult=[1 1 1 1 1 2 2 2 2 2 3 3 3 3 3 4 4 4 4 4 5 5 5 5 5]; %How many images you wanted to test against the trained data
%%%%%%%%%%%%%%% CMC calculation %%%%%%%
    if index(i)==rresult(i)
        match(1)=match(1)+1;%%%%%%%first rank matching number
    else
        [svals,idx]=sort(eud(:));
        index2(i)=idx(2);
        if index2(i)==rresult(i)
            match(2)=match(2)+1;%%%%%%%second rank matching number
        end
        
        
    end
end

for i=1:10  %% if show CMC of the 1st to 10th rank matching number 
cmc(i)=sum(match(1:i))/num_imt;
end
figure,plot(cmc);title('CMC curve');







