echo "当前位置："`pwd`
echo "当前用户："`whoami`

# 获取docker命令
export PATH=$PATH:/usr/bin

# 定义变量
WORKHOME=$1
BUILD_NUMBER=$2
API_NAME="sbm"
API_VERSION="$BUILD_NUMBER"
API_PORT=8089
DOCKER_REGISTRY="jackchow"
IMAGE_NAME="$DOCKER_REGISTRY/$API_NAME:$BUILD_NUMBER"
CONTAINER_NAME=$API_NAME
docker --version

# 进入target 目录复制Dockerfile 文件
#cd $WORKSPACE/target
#cp classes/SBM .
cd $WORKHOME

#删除同名docker容器
cid=$(docker ps -a| grep "$CONTAINER_NAME" | awk '{print $1}')
if [ "$cid" != "" ]; then
   echo "删除同名docker容器:"$(docker ps -a| grep "$CONTAINER_NAME" | awk '{print $12}')
   docker rm -f $cid
fi

#删除同名docker镜像
cid=$(docker images| grep "$DOCKER_REGISTRY/$API_NAME" | awk '{print $3}')
if [ "$cid" != "" ]; then
   echo "删除同名docker镜像:"$(docker images| grep "$DOCKER_REGISTRY/$API_NAME" | awk '{print $1}')
   docker rmi -f $cid
fi

#构建docker镜像
docker build -t $IMAGE_NAME .

#推送docker镜像
echo "推送docker镜像:"$IMAGE_NAME
docker push $IMAGE_NAME

#启动docker 容器
docker run -d -p $API_PORT:8080 --name $CONTAINER_NAME $IMAGE_NAME

#删除 Dockerfile 文件
echo "删除Dockerfile文件"
rm -f Dockerfile